package `in`.vikins.fingertip.homescreen.models

data class Recyclerlist (
    val articles:ArrayList<News>
    )
data class News(
    val title:String,
    val url:String,
    val publishedAt:String,
    val author:String,
    val urlToImage:String
)