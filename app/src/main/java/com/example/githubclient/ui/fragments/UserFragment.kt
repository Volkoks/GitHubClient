package com.example.githubclient.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.githubclient.R
import com.example.githubclient.mvp.model.entity.GitHubUser


class UserFragment : Fragment() {
    companion object{
        fun newInstance():Fragment{
            val fragment = UserFragment()

            return fragment
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = View.inflate(context, R.layout.fragment_user, null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
