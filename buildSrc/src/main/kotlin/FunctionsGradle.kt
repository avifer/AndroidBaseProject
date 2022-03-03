import java.io.File
import java.util.*

object FunctionsGradle {

    private const val DIR_PRIVATE_DATA = "privateData"
    private const val FINAL_FILE_PROPERTIES = "SignConfig.properties"

    private const val PATH_FILE = "PATH_FILE"
    private const val STORE_PASSWORD = "STORE_PASSWORD"
    private const val KEY_ALIAS = "KEY_ALIAS"
    private const val KEY_PASSWORD = "KEY_PASSWORD"

    enum class SignConfig {
        RELEASE, DEBUG;

        fun getPathFile() =
            getAbsolutePath() + "/" + DIR_PRIVATE_DATA + "/" + name.toLowerCase(Locale.ROOT) + FINAL_FILE_PROPERTIES

    }

    private fun getAbsolutePath() = System.getProperty("user.dir")

    private fun getPropertiesFile(signConfig: SignConfig): Properties =
        Properties().apply { load(File(signConfig.getPathFile()).inputStream()) }

    fun getFileStore(signConfig: SignConfig): File =
        File(
            getAbsolutePath() + "/" + DIR_PRIVATE_DATA + "/" + getPropertiesFile(signConfig).getProperty(
                PATH_FILE
            )
        )

    fun getStorePassword(signConfig: SignConfig): String =
        getPropertiesFile(signConfig).getProperty(STORE_PASSWORD)

    fun getKeyAlias(signConfig: SignConfig): String =
        getPropertiesFile(signConfig).getProperty(KEY_ALIAS)

    fun getKeyPassword(signConfig: SignConfig): String =
        getPropertiesFile(signConfig).getProperty(KEY_PASSWORD)

}