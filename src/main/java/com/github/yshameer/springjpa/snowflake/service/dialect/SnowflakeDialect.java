package com.github.yshameer.springjpa.snowflake.service.dialect;

import org.hibernate.dialect.DatabaseVersion;
import org.hibernate.dialect.Dialect;

public class SnowflakeDialect extends Dialect {
    public SnowflakeDialect() {
        super(DatabaseVersion.make(0, 0));
    }

}
