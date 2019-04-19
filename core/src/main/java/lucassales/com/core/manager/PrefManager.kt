package lucassales.com.core.manager

interface PrefManager {
    suspend fun getInt(key: String, defaultValue: Int): Int
    suspend fun setInt(key: String, value: Int)
    suspend fun getLong(key: String, defaultValue: Long): Long
    suspend fun setLong(key: String, value: Long)
    suspend fun getBoolean(key: String, defaultValue: Boolean): Boolean
    suspend fun setBoolean(key: String, value: Boolean)
    suspend fun getFloat(key: String, defaultValue: Float): Float
    suspend fun setFloat(key: String, value: Float)
    suspend fun getString(key: String, defaultValue: String?): String?
    suspend fun setString(key: String, value: String)
    suspend fun remove(key: String)
}