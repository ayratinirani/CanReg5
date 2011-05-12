/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package canreg.common.database;

import canreg.common.database.DatabaseRecord;
import java.util.Set;

/**
 *
 * @author ervikm
 */
public class Tools {

    // Ref: http://db.apache.org/derby/docs/10.1/ref/rrefkeywords29722.html    
    private static String[] reservedWordsSQL = {"ADD",
        "ALL",
        "ALLOCATE",
        "ALTER",
        "AND",
        "ANY",
        "ARE",
        "AS",
        "ASC",
        "ASSERTION",
        "AT",
        "AUTHORIZATION",
        "AVG",
        "BEGIN",
        "BETWEEN",
        "BIT",
        "BOOLEAN",
        "BOTH",
        "BY",
        "CALL",
        "CASCADE",
        "CASCADED",
        "CASE",
        "CAST",
        "CHAR",
        "CHARACTER",
        "CHECK",
        "CLOSE",
        "COLLATE",
        "COLLATION",
        "COLUMN",
        "COMMIT",
        "CONNECT",
        "CONNECTION",
        "CONSTRAINT",
        "CONSTRAINTS",
        "CONTINUE",
        "CONVERT",
        "CORRESPONDING",
        "COUNT",
        "CREATE",
        "CURRENT",
        "CURRENT_DATE",
        "CURRENT_TIME",
        "CURRENT_TIMESTAMP",
        "CURRENT_USER",
        "CURSOR",
        "DEALLOCATE",
        "DEC",
        "DECIMAL",
        "DECLARE",
        "DEFERRABLE",
        "DEFERRED",
        "DELETE",
        "DESC",
        "DESCRIBE",
        "DIAGNOSTICS",
        "DISCONNECT",
        "DISTINCT",
        "DOUBLE",
        "DROP",
        "ELSE",
        "END",
        "ENDEXEC",
        "ESCAPE",
        "EXCEPT",
        "EXCEPTION",
        "EXEC",
        "EXECUTE",
        "EXISTS",
        "EXPLAIN",
        "EXTERNAL",
        "FALSE",
        "FETCH",
        "FIRST",
        "FLOAT",
        "FOR",
        "FOREIGN",
        "FOUND",
        "FROM",
        "FULL",
        "FUNCTION",
        "GET",
        "GET_CURRENT_CONNECTION",
        "GLOBAL",
        "GO",
        "GOTO",
        "GRANT",
        "GROUP",
        "HAVING",
        "HOUR",
        "IDENTITY",
        "IMMEDIATE",
        "IN",
        "INDICATOR",
        "INITIALLY",
        "INNER",
        "INOUT",
        "INPUT",
        "INSENSITIVE",
        "INSERT",
        "INT",
        "INTEGER",
        "INTERSECT",
        "INTO",
        "IS",
        "ISOLATION",
        "JOIN",
        "KEY",
        "LAST",
        "LEFT",
        "LIKE",
        "LONGINT",
        "LOWER",
        "LTRIM",
        "MATCH",
        "MAX",
        "MIN",
        "MINUTE",
        "NATIONAL",
        "NATURAL",
        "NCHAR",
        "NVARCHAR",
        "NEXT",
        "NO",
        "NOT",
        "NULL",
        "NULLIF",
        "NUMERIC",
        "OF",
        "ON",
        "ONLY",
        "OPEN",
        "OPTION",
        "OR",
        "ORDER",
        "OUT",
        "OUTER",
        "OUTPUT",
        "OVERLAPS",
        "PAD",
        "PARTIAL",
        "PREPARE",
        "PRESERVE",
        "PRIMARY",
        "PRIOR",
        "PRIVILEGES",
        "PROCEDURE",
        "PUBLIC",
        "READ",
        "REAL",
        "REFERENCES",
        "RELATIVE",
        "RESTRICT",
        "REVOKE",
        "RIGHT",
        "ROLLBACK",
        "ROWS",
        "RTRIM",
        "SCHEMA",
        "SCROLL",
        "SECOND",
        "SELECT",
        "SESSION_USER",
        "SET",
        "SMALLINT",
        "SOME",
        "SPACE",
        "SQL",
        "SQLCODE",
        "SQLERROR",
        "SQLSTATE",
        "SUBSTR",
        "SUBSTRING",
        "SUM",
        "SYSTEM_USER",
        "TABLE",
        "TEMPORARY",
        "TIMEZONE_HOUR",
        "TIMEZONE_MINUTE",
        "TO",
        "TRAILING",
        "TRANSACTION",
        "TRANSLATE",
        "TRANSLATION",
        "TRUE",
        "UNION",
        "UNIQUE",
        "UNKNOWN",
        "UPDATE",
        "UPPER",
        "USER",
        "USING",
        "VALUES",
        "VARCHAR",
        "VARYING",
        "VIEW",
        "WHENEVER",
        "WHERE",
        "WITH",
        "WORK",
        "WRITE",
        "XML",
        "XMLEXISTS",
        "XMLPARSE",
        "XMLSERIALIZE",
        "YEAR"
    };

    /**
     * 
     * @param word
     * @return
     */
    static public boolean isReservedWord(String word) {
        boolean found = false;
        int i = 0;
        while (!found && i < reservedWordsSQL.length) {
            found = word.equalsIgnoreCase(reservedWordsSQL[i++]);
        }
        return found;
    }

    /**
     *
     * @param newRecord
     * @param oldRecord
     * @param variablesToSkip
     * @return
     */
    static public boolean newRecordContainsNewInfo(DatabaseRecord newRecord, DatabaseRecord oldRecord, Set<String> variablesToSkip) {
        boolean noNewInfo = true;
        // First check if the records are the same class
        if (newRecord.getClass().isInstance(oldRecord)) {
            String[] variableNames = newRecord.getVariableNames();

            int pos = 0;

            Object value1;
            Object value2;

            while (noNewInfo && pos < variableNames.length) {
                if (variablesToSkip.contains(canreg.common.Tools.toLowerCaseStandardized(variableNames[pos]))) {
                    // skip this variable
                } else {
                    // compare
                    value1 = newRecord.getVariable(variableNames[pos]);
                    value2 = oldRecord.getVariable(variableNames[pos]);
                    if (value1==null || value2==null){
                        noNewInfo = (value1==value2);
                    }
                    else if (!value1.equals(value2)) {
                        noNewInfo = false;
                    }
                }
                pos++;
            }
        } else {
            noNewInfo = false;
        }
        return !noNewInfo;
    }
}