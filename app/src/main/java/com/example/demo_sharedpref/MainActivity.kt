package com.example.demo_sharedpref

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 创建/获取一个sp文件
        val sharedPref = this.getSharedPreferences("any_name_is_ok", Context.MODE_PRIVATE)

        // 分别绑定视图控件
        val show = findViewById<TextView>(R.id.show)
        val addButton = findViewById<Button>(R.id.add)
        val getButton = findViewById<Button>(R.id.get)
        val removeButton = findViewById<Button>(R.id.remove)

        // 设置”添加按钮“的点击事件
        addButton.setOnClickListener {
            // 进入sp文件的编辑状态
            with (sharedPref.edit()) {
                // 写入一个值为String类型的键值对
                putString("name", "张三")
                // 写入一个值为Int类型的键值对
                putInt("age", 20)
                // 写入一个值为Boolean类型的键值对
                putBoolean("adult", true)
                apply()
            }
        }

        // 设置”读取按钮“的点击事件
        getButton.setOnClickListener {
            val name = sharedPref.getString("name", "noValue")
            val age = sharedPref.getInt("age", 0)
            val adult = sharedPref.getBoolean("adult", false)
            show.text = "姓名：$name, 年龄：$age, 是否成年：$adult"
        }

        // 设置”删除按钮“的点击事件
        removeButton.setOnClickListener {
            // 进入sp文件的编辑状态
            with (sharedPref.edit()) {
                remove("name")
                remove("age")
                remove("adult")
                apply()
            }
        }
    }
}
