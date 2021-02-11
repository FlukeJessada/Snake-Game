package lzy.game.snake.lwjgl3

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import lzy.game.snake.Board

object DesktopLauncher {
    @JvmStatic
    fun main(args: Array<String>) {
        getEntryPoint()
    }

    fun getLwjglConfig() : Lwjgl3ApplicationConfiguration {
        var config = Lwjgl3ApplicationConfiguration()
        config.setTitle("The Snake")
        config.setWindowedMode(300, 300)
        return config
    }

    fun getEntryPoint() : Lwjgl3Application {
        return Lwjgl3Application(Board(), getLwjglConfig())
    }
}