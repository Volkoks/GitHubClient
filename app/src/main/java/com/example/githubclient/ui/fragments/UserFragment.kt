package com.example.githubclient.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.githubclient.R
import com.example.githubclient.mvp.model.entity.GitHubUser
import kotlinx.android.synthetic.main.fragment_user.*


class UserFragment : Fragment() {
    companion object{
        fun newInstance(user:GitHubUser):Fragment{
            val fragment = UserFragment()
            var bundle = Bundle()
            bundle.putParcelable("user",user)
            fragment.arguments = bundle
            return fragment
        }
        var user:GitHubUser? = null
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = View.inflate(context, R.layout.fragment_user, null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        user = arguments?.getParcelable("user")
        user_name_tv.text = user?.login
    }
}
