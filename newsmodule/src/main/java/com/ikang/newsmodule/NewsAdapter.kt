package com.ikang.newsmodule

import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.chad.library.adapter.base.BaseQuickAdapter
import com.example.newsmodule.R
import com.example.newsmodule.databinding.NewsItemNewsListAdapterBinding
import com.ikang.data.entity.NewsListBean
import com.ikang.libmvi.base.ui.BaseDBViewHoder

/**
 * @author ikang-renwei
 * @Date 2019/12/23 17:50
 * @describe
 */
class NewsListAdapter : BaseQuickAdapter<NewsListBean, BaseDBViewHoder<NewsItemNewsListAdapterBinding>>(R.layout.news_item_news_list_adapter) {
    override fun convert(helper: BaseDBViewHoder<NewsItemNewsListAdapterBinding>?, item: NewsListBean?) {
        helper?.getBinding()?.itemData = item
        helper?.getBinding()?.executePendingBindings()
    }

    override fun getItemView(layoutResId: Int, parent: ViewGroup?): View {
        val binding = DataBindingUtil.inflate<NewsItemNewsListAdapterBinding>(mLayoutInflater,layoutResId,parent,false)
        return binding.root.apply {
            setTag(R.id.BaseQuickAdapter_databinding_support,binding)
        }
    }
}