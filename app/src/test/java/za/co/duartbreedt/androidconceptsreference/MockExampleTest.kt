package za.co.duartbreedt.androidconceptsreference

import android.content.Context
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class MockExampleTest {

    @Mock
    private lateinit var mockContext: Context

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)

        whenever(mockContext.applicationContext).thenReturn(mockContext)
    }

    @Test
    fun readStringFromContext() {

        val customLayout = MyCustomLayout(mockContext)

        whenever(mockContext.getString(R.string.app_name)) doReturn "Ta da"

        val result: String = customLayout.getAppName()

        assertEquals("Ta da", result)
    }
}