package ico.instagram.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FooterView(modifier: Modifier) {
    Column(modifier = modifier) {
        Divider(
            Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp).fillMaxWidth())
        Spacer(modifier = Modifier.size(16.dp))
        Row(Modifier.fillMaxWidth().padding(vertical = 8.dp), horizontalArrangement = Arrangement.Center) {
           Text(text = "Don't have an account?", fontSize = 14.sp)
           Text(text = "Sign up.", Modifier.padding(horizontal = 8.dp), fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4EA8E9))
       }
    }
}