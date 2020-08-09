package pl.sda.dao;

public class Main {

    public static void main(String[] args) {
        AccountJdbcDaoImpl accountJdbcDao = new AccountJdbcDaoImpl();
        accountJdbcDao.insert(100, "023432587237324");
        accountJdbcDao.insert(200, "456473575465465");
        accountJdbcDao.insert(300, "356564544477777");

    }
}
