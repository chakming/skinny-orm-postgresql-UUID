import java.util.UUID

import Model.Member
import org.scalatest.{Matchers, fixture}
import scalikejdbc._
import scalikejdbc.config.DBs
import scalikejdbc.scalatest.AutoRollback

class MemberSpec extends fixture.FlatSpec with AutoRollback with Matchers {
  DBs.setupAll()

  override def fixture(implicit session: DBSession) {
    sql"""
       |CREATE TABLE IF NOT EXISTS Member (
       |	uuid UUID PRIMARY KEY,
       |	name VARCHAR(255) NOT NULL,
       |	deleted_at TIMESTAMP NULL
       |);
""".stripMargin.execute.apply()
  }

  it should "create a member record" in { implicit session =>
    val column = Member.column
    Member.createWithNamedValues(
      column.uuid -> UUID.randomUUID(),
      column.name -> "Skinny"
    )

    Member.count() should be(1)
  }

}
