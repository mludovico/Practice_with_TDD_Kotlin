package com.example.practicewithtdd_kotlin

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(RobolectricTestRunner::class)
class ExampleUnitTest {
    private val context = ApplicationProvider.getApplicationContext<Context>()
    private val sharedPreferences =
        context.getSharedPreferences("com.example.practicewithtdd_kotlin.PREFERENCES", Context.MODE_PRIVATE)
    private val contactHelper = ContactHelper(sharedPreferences)

    @Test
    fun `Quando chamar o metodo getContactsList() com 2 contatos, deve retornar uma lista de 2 contatos`() {
        //Prepare
        mock2ContactList()

        // Validate
        val list = contactHelper.getContactsList()
        assertEquals(2, list.size)
    }

    @Test
    fun `Quando chamar o metodo getContactsList sem contatos, deve retornar uma lista vazia` () {
        // Prepare
        mockEmptyList()

        // Validate
        val list = contactHelper.getContactsList()
        assertEquals(0, list.size)
    }

    private fun mock2ContactList () {
        contactHelper.setContactsList(
            arrayListOf(
                Contact(
                    "Marcelo Ludovico de Paula",
                    "+ 55 19 996856275",
                    "img1.jpg"
                ),
                Contact(
                    "João Ribeiro",
                    "+41 675 7634853",
                    "img2.jpg"
                )
            )
        )
    }

    private fun mockEmptyList () {
        contactHelper.setContactsList(arrayListOf())
    }
}