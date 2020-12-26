package abstractFactory.dao;

public class FactoryProducer {
    public MysqlDaoFactory createMysqlDaoFactory(){
        return new MysqlDaoFactory();
    }

    public SqlServerDaoFactory createSqlServerDaoFactory(){
        return new SqlServerDaoFactory();
    }
}
