package Model

import java.util.UUID

import scalikejdbc.WrappedResultSet
import skinny.orm.SkinnyCRUDMapperWithId
import skinny.orm.feature.SoftDeleteWithTimestampFeatureWithId
import scalikejdbc._

case class Member(uuid: UUID, name: String)

object Member extends SkinnyCRUDMapperWithId[UUID, Member]
with SoftDeleteWithTimestampFeatureWithId[UUID, Member] {
  override def defaultAlias = createAlias("m")

  override def primaryKeyFieldName = "uuid"

  // use alternative id generator instead of DB's auto-increment
  override def useExternalIdGenerator = true

  override def generateId = UUID.randomUUID

  override def idToRawValue(id: UUID) = id.toString

  override def extract(rs: WrappedResultSet, m: ResultName[Member]) = new Member(
    uuid = rawValueToId(rs.string(m.uuid)),
    name = rs.string(m.name)
  )

  override def rawValueToId(value: Any) = UUID.fromString(value.toString)

}