package io.github.gtn1024.cangjieplayground.app.controller

import io.github.gtn1024.cangjieplayground.shared.request.CompilerRunRequest
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam

@Path("/{version}/compiler")
class CompilerController {
    @Path("run")
    fun run(@PathParam("version") version: String, request: CompilerRunRequest): Map<String, *> {
        return mapOf(
            "compilerVersion" to version,
            "message" to "Hi",
            "data" to request,
        )
    }
}
