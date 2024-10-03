package io.github.gtn1024.cangjieplayground.shared.request

data class CompilerRunRequest(
    val args: String?,
    val type: CodeType,
    val files: List<FileRequest>,
    val stdin: String?,
)

data class FileRequest(
    val content: String,
    val filename: String,
)

enum class CodeType {
    SINGLE,
}
