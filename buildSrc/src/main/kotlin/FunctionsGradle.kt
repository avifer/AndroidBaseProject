import java.io.File
import java.util.*

object FunctionsGradle {

    private const val PATH_FILE = "PATH_FILE"
    private const val STORE_PASSWORD = "STORE_PASSWORD"
    private const val KEY_ALIAS = "KEY_ALIAS"
    private const val KEY_PASSWORD = "KEY_PASSWORD"

    enum class SignConfig {
        RELEASE, DEBUG;

        fun getPathFile() =
            "privateData/${this.name.toLowerCase(Locale.ROOT)}SignConfig.properties"

    }

    private fun getPropertiesFile(signConfig: SignConfig): Properties =
        Properties().apply { load(File(signConfig.getPathFile()).inputStream()) }

    fun getFileStore(signConfig: SignConfig): File =
        File("privateData/${getPropertiesFile(signConfig).getProperty(PATH_FILE)}")

    fun getStorePassword(signConfig: SignConfig): String =
        getPropertiesFile(signConfig).getProperty(STORE_PASSWORD)

    fun getKeyAlias(signConfig: SignConfig): String =
        getPropertiesFile(signConfig).getProperty(KEY_ALIAS)

    fun getKeyPassword(signConfig: SignConfig): String =
        getPropertiesFile(signConfig).getProperty(KEY_PASSWORD)

}