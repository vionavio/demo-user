package com.viona.demo.user.controller

import com.viona.demo.BaseResponse
import com.viona.demo.user.entity.User
import com.viona.demo.user.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/user")
class UserController {

    @Autowired
    private lateinit var userService: UserService

    @GetMapping
    fun getUser(): BaseResponse<List<User>> {
        return BaseResponse(
                status = true,
                message = "Success",
                data = userService.getUsers()
        )
    }

    @GetMapping("/{name}")
    fun getUser(
            @PathVariable(value = "name") userName: String
    ): BaseResponse<User?> {

        return BaseResponse(
                status = true,
                message = "success",
                data = userService.getUserByName(userName)
        )
    }

    @PostMapping
    fun addUser(
            @RequestBody user: User
    ): BaseResponse<List<User>> {

        return BaseResponse(
                status = true,
                message = "Success",
                data = userService.addUser(user)
        )
    }

    @GetMapping("/ids")
    fun getIds(): BaseResponse<List<String>> {
        return BaseResponse(
                status = true,
                message = "success",
                data = userService.getIds()
        )
    }
}