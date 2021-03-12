package com.study.android.wan.ui.knowledge.vo

/**
 * Description:
 * @author: xuyunlong
 * Date: 2021/3/12 17:14
 * @version 2.2
 */
data class KnowledgeVo(
    val children: List<KnowledgeVo>,
    val courseId: Int,
    val id: Int,
    val name: String,
    val order: Int,
    val parentChapterId: Int,
    val visible: Int
)