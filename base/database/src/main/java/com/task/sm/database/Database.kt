package com.task.sm.database

/**
 * Helper interface for direct communication with database.
 */
interface Database {

    /**
     * Deletes all rows from all the tables that are registered to this database as entities.
     */
    fun clearAllTables()

    /**
     * Calls the specified suspending [block] in a database transaction.
     */
    suspend fun <R> withTransaction(block: suspend () -> R): R
}
