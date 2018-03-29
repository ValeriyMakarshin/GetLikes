package com.getlikes.main.choice.root

import com.getlikes.Navigator
import com.getlikes.R
import com.getlikes.core.ActivityInfo
import com.getlikes.core.BaseFragment
import com.github.salomonbrys.kodein.instance

class ChoiceRootFragment : BaseFragment<ChoiceRootContract.View, ChoiceRootContract.Presenter>(),
    ChoiceRootContract.View {

    override val activityInfo: ActivityInfo = ActivityInfo(R.layout.fragment_choice_root)

    override val presenter: ChoiceRootContract.Presenter by instance()

    override fun choicePhoto() {
        Navigator.choicePhoto(fragmentManager, R.id.uiContainerFl)
    }

}
