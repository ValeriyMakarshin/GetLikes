package com.getlikes.core

import me.dmdev.rxpm.PresentationModel

open class BasePresentationModel : PresentationModel() {
    //    val data = State<List<T>>(emptyList())
    val inProgress = State(false)
    val errorMessage = Command<String>()
//    val refreshAction = Action<Unit>()


}
