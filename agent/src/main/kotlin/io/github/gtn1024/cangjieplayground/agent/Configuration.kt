package io.github.gtn1024.cangjieplayground.agent

object Configuration {
    /** 服务端地址 */
    val SERVER_HOST = System.getenv("SERVER_HOST") ?: "http://127.0.0.1:8080"

    /** 沙箱地址 */
    val SANDBOX_SERVER = System.getenv("SANDBOX_SERVER") ?: "http://127.0.0.1:5050"

    var token: String? = null

    /** 评测线程数 */
    val THREAD_COUNT = System.getenv("THREAD_COUNT")?.toInt() ?: 5

    fun memoryUsed(): Long {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()
    }

    fun memoryTotal(): Long {
        return Runtime.getRuntime().totalMemory()
    }
}
