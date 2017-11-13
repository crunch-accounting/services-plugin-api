package uk.co.crunch.platform.api.database;

import org.junit.Test;
import uk.co.crunch.platform.api.database.MySqlDataSource.Instance;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.co.crunch.platform.api.database.VaultDatabaseCommands.*;

public class MySqlDataSourceTest {

    @Test
    @MySqlDataSource(schema="insurancedb", instance=@Instance(host="rds-wordpress.x.y", customConfigName="wordpress"), grants="ALL")
    public void testLongForm() throws NoSuchMethodException {
        final MySqlDataSource ann = this.getClass().getMethod("testLongForm").getAnnotation(MySqlDataSource.class);
        assertThat(ann.schema()).isEqualTo("insurancedb");
        assertThat(ann.instance().host()).isEqualTo("rds-wordpress.x.y");
        assertThat(ann.grants()).isEqualTo("ALL");

        assertThat( getConfigName(ann) ).isEqualTo("wordpress");
        assertThat( getRoleName(ann) ).isEqualTo("insurancedb_default");
        assertThat( getDbConnectionUrl(ann) ).isEqualTo("@tcp(rds-wordpress.x.y:3306)/");
        assertThat( getUserCreationStatement(ann) ).isEqualTo("CREATE USER '{{name}}'@'%' IDENTIFIED BY '{{password}}';GRANT ALL ON insurancedb.* TO '{{name}}'@'%';");
    }

    @Test
    @MySqlDataSource(schema="insurancedb", customConfigName="readonly", grants="SELECT")
    public void testLongFormReadOnly() throws NoSuchMethodException {
        final MySqlDataSource ann = this.getClass().getMethod("testLongFormReadOnly").getAnnotation(MySqlDataSource.class);
        assertThat(ann.schema()).isEqualTo("insurancedb");
        assertThat(ann.instance().host()).isEqualTo("rds.service.consul");
        assertThat(ann.grants()).isEqualTo("SELECT");

        assertThat( getConfigName(ann) ).isEqualTo("rds_service_consul");
        assertThat( getRoleName(ann) ).isEqualTo("insurancedb_readonly");
        assertThat( getDbConnectionUrl(ann) ).isEqualTo("@tcp(rds.service.consul:3306)/");
        assertThat( getUserCreationStatement(ann) ).isEqualTo("CREATE USER '{{name}}'@'%' IDENTIFIED BY '{{password}}';GRANT SELECT ON insurancedb.* TO '{{name}}'@'%';");
    }

    @Test
    @MySqlDataSource(schema="blahDb")
    public void testShortForm() throws NoSuchMethodException {
        final MySqlDataSource ann = this.getClass().getMethod("testShortForm").getAnnotation(MySqlDataSource.class);
        assertThat(ann.schema()).isEqualTo("blahDb");
        assertThat(ann.instance().host()).isEqualTo("rds.service.consul");
        assertThat(ann.grants()).isEqualTo("ALL");

        assertThat( getConfigName(ann) ).isEqualTo("rds_service_consul");
        assertThat( getRoleName(ann) ).isEqualTo("blahDb_default");
        assertThat( getDbConnectionUrl(ann) ).isEqualTo("@tcp(rds.service.consul:3306)/");
        assertThat( getUserCreationStatement(ann) ).isEqualTo("CREATE USER '{{name}}'@'%' IDENTIFIED BY '{{password}}';GRANT ALL ON blahDb.* TO '{{name}}'@'%';");
    }
}
