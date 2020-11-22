package com.example.githubclient.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubclient.R
import com.example.githubclient.mvp.presenter.list.IReposUserPresenter
import com.example.githubclient.mvp.view.ReposUserItemView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_repos_user.view.*

class ReposUserAdapter(val presenter: IReposUserPresenter) :
    RecyclerView.Adapter<ReposUserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_repos_user, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.pos = position
        holder.containerView.setOnClickListener {
            presenter.itemClickListener?.invoke(holder)
        }
        presenter.bindView(holder)
    }

    override fun getItemCount() = presenter.getCount()


    inner class ViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer, ReposUserItemView {

        override var pos: Int = -1

        override fun setReposName(name: String) = with(containerView) {
            name_repos_user_tv.text = name
        }
    }
}