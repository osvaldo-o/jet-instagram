package ico.instagram.ui.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen() {
    Box(
        Modifier
            .fillMaxSize()
            .padding(12.dp)) {
        HeaderView(Modifier.align(Alignment.TopEnd))
        BodyView(
            Modifier
                .align(Alignment.Center)
                .fillMaxWidth())
        FooterView(Modifier.fillMaxWidth().align(Alignment.BottomCenter))
    }
}