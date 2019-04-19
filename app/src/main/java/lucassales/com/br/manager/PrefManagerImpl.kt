package lucassales.com.br.manager

import android.content.SharedPreferences
import androidx.core.content.edit
import lucassales.com.core.manager.PrefManager

class PrefManagerImpl(private val sharedPrefs: SharedPreferences) : PrefManager {

    override suspend fun getInt(key: String, defaultValue: Int): Int {
        return sharedPrefs.getInt(key, defaultValue)
    }

    override suspend fun setInt(key: String, value: Int) {
        sharedPrefs.edit(commit = true) {
            putInt(key, value)
        }
    }

    override suspend fun getLong(key: String, defaultValue: Long): Long =
        sharedPrefs.getLong(key, defaultValue)

    override suspend fun setLong(key: String, value: Long) {
        sharedPrefs.edit(commit = true) {
            putLong(key, value)
        }
    }

    override suspend fun getBoolean(key: String, defaultValue: Boolean): Boolean =
        sharedPrefs.getBoolean(key, defaultValue)

    override suspend fun setBoolean(key: String, value: Boolean) {
        sharedPrefs.edit(commit = true) {
            putBoolean(key, value)
        }
    }

    override suspend fun getFloat(key: String, defaultValue: Float): Float =
        sharedPrefs.getFloat(key, defaultValue)

    override suspend fun setFloat(key: String, value: Float) {
        sharedPrefs.edit(commit = true) {
            putFloat(key, value)
        }
    }

    override suspend fun getString(key: String, defaultValue: String?): String? =
        sharedPrefs.getString(key, defaultValue)

    override suspend fun setString(key: String, value: String) {
        sharedPrefs.edit(commit = true) {
            putString(key, value)
        }
    }

    override suspend fun remove(key: String) {
        sharedPrefs.edit(true) {
            remove(key)
        }
    }
}
