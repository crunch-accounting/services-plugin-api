package uk.co.crunch.platform.api.database;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CoreDatabaseDataSourceTest {

    @Test
    @CoreDatabaseDataSource(tables={"user_credentials", "subscription_type", "client_company", "client"})
    public void testTables() throws NoSuchMethodException {
        final CoreDatabaseDataSource ann = this.getClass().getMethod("testTables").getAnnotation(CoreDatabaseDataSource.class);
        assertThat(ann.tables()).isEqualTo( new String[]{"user_credentials", "subscription_type", "client_company", "client"} );
        assertThat(ann.grants()).isEqualTo("SELECT");
    }

    @Test
    @CoreDatabaseDataSource(tables={"user_credentials"}, grants = "SELECT,UPDATE,DELETE")
    public void testTablesWithGrants() throws NoSuchMethodException {
        final CoreDatabaseDataSource ann = this.getClass().getMethod("testTablesWithGrants").getAnnotation(CoreDatabaseDataSource.class);
        assertThat(ann.tables()).isEqualTo( new String[]{"user_credentials"} );
        assertThat(ann.grants()).isEqualTo("SELECT,UPDATE,DELETE");
    }
}
