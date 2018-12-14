package garg.sarthik.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lv = lvKotlin
        val btn = btn
        val al = ArrayList<String>()
        populate(al)

        val adapter = ArrayAdapter<String>(
                this,
                R.layout.item_layout,
                R.id.tvName,
                al

        )

        lv.setAdapter(adapter)
        btn.setOnClickListener { v : View ->  Log("hello")}

    }

    private fun populate(a1: ArrayList<String>) {
        a1.add("f1")
        a1.add("f2")
        a1.add("f3")
        a1.add("f4")
        a1.add("f5")
        a1.add("f6")
        a1.add("f7")
        a1.add("f8")
        a1.add("f9")
        a1.add("f10")
        a1.add("f11")
    }

    fun Log(s :String):Unit{

        Log.e("clicked",s)
    }
}
