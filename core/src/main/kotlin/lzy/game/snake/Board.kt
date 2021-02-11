package lzy.game.snake

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class Board : ApplicationAdapter() {
    private val BORDER_WIDTH: Int = 300
    private val BORDER_HEIGHT: Int = 300

    private val DOT_SIZE: Int = 10
    private val ALL_DOTS: Int = (BORDER_WIDTH / DOT_SIZE) * (BORDER_HEIGHT / DOT_SIZE)
    private val RAND_POS: Int = 29

    private val x = IntArray(ALL_DOTS)
    private val y = IntArray(ALL_DOTS)

    private var dots: Int = 3
    private var score: Int = 0
    private var apple_x: Int? = null
    private var apple_y: Int? = null

    private var textureBall: Texture? = null
    private var textureApple: Texture? = null
    private var textureHead: Texture? = null

    private var sBatch: SpriteBatch? = null

    override fun create() {
        sBatch = SpriteBatch()

        textureBall = Texture(Gdx.files.internal("dot.png"))
        textureApple = Texture(Gdx.files.internal("apple.png"))
        textureHead = Texture(Gdx.files.internal("head.png"))

        // initialize value for new game instance
        newInstance()
    }

    /**
     * Initialize instance variable for our game
     */
    fun newInstance() {
        dots = 3
        score = 0

        for (i in 0..dots) {
            x[i] = 50 - i * 10
            y[i] = 50
        }

         locateApple()
    }

    fun locateApple() {
        TODO("Implement function from original code")
    }

    override fun render() {
        // Set background color to RGBA(1,1,1,1) or White
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        sBatch!!.begin()
//        sBatch!!.draw(textureApple, apple_x!!.toFloat(), apple_y!!.toFloat())
        // draw the snake in game loop
        for (i in 0..dots) {
            // draw head at 1st pos of array
            if (i == 0)
                sBatch!!.draw(textureHead, x[i].toFloat(), y[i].toFloat())
            else
                sBatch!!.draw(textureBall, x[i].toFloat(), y[i].toFloat())
        }
        sBatch!!.end()
    }

    override fun dispose() {
        sBatch!!.dispose()
        textureBall!!.dispose()
        textureHead!!.dispose()
        textureApple!!.dispose()
    }
}