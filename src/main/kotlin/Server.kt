class Console {

    fun launch() {
        while (true) {

            Thread.sleep(FRAME_LENGTH)
        }
    }

    companion object {
        private const val FRAME_LENGTH = 33L
    }
}