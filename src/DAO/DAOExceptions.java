package DAO;


/**
* Represents Exceptions thrown by the Data Access Layer.
*/
public class DAOExceptions extends RuntimeException {
public DAOExceptions() {
}

public DAOExceptions(String message) {
super(message);
}

public DAOExceptions(Throwable cause) {
super(cause);
}

public DAOExceptions(String message, Throwable cause) {
super(message, cause);
}
}