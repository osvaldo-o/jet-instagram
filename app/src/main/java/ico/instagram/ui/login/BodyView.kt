package ico.instagram.ui.login

import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ico.instagram.R

@Composable
fun BodyView(modifier: Modifier) {
    var emailState by remember {
        mutableStateOf("")
    }
    var passwordState by remember {
        mutableStateOf("")
    }
    var enabledButtonState by remember {
        mutableStateOf( false )
    }
    Column(modifier = modifier) {
        LogoItem(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(22.dp))
        EmailPasswordItem(emailState, passwordState, Modifier.fillMaxWidth(),
            {
                emailState = it
                enabledButtonState = enabledButtonLogin(emailState, passwordState)
            },
            {
                passwordState = it
                enabledButtonState = enabledButtonLogin(emailState, passwordState)
            },)
        Spacer(modifier = Modifier.height(10.dp))
        ForgotPasswordItem(modifier = Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.height(14.dp))
        ButtonLoginItem(enabled = enabledButtonState, modifier = modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(14.dp))
        DividerLoginItem()
        Spacer(modifier = Modifier.height(14.dp))
        SocialLoginItem()
    }
}

@Composable
fun LogoItem(modifier: Modifier) = Image(painter = painterResource(id = R.drawable.insta), contentDescription = "Logo Instagram", modifier = modifier)

@Composable
fun EmailPasswordItem(email: String, password: String, modifier: Modifier, onChangeEmail: (String) -> Unit, onChangePassword: (String) -> Unit) {
    TextField(
        value = email,
        onValueChange = {onChangeEmail(it)},
        modifier = modifier,
        placeholder = { Text(text = "Email")},
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color(0xFFB2B2B2),
                focusedContainerColor = Color(0xFFFAFAFA),
                unfocusedContainerColor = Color(0xFFFAFAFA),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
    )
    Spacer(modifier = Modifier.height(12.dp))
    var visibilityIconPassword by remember {
        mutableStateOf(false)
    }
    TextField(
        value = password,
        onValueChange = {onChangePassword(it)},
        modifier = modifier,
        placeholder = { Text(text = "Password")},
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password),
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color(0xFFB2B2B2),
            focusedContainerColor = Color(0xFFFAFAFA),
            unfocusedContainerColor = Color(0xFFFAFAFA),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        trailingIcon = {
            IconButton(onClick = { visibilityIconPassword = !visibilityIconPassword }) {
                Icon(imageVector = if (visibilityIconPassword) Icons.Filled.VisibilityOff else Icons.Filled.Visibility  , contentDescription = "Icon visibility")
            }
        },
        visualTransformation = if (visibilityIconPassword) VisualTransformation.None else PasswordVisualTransformation()
    )
}
@Composable
fun ForgotPasswordItem(modifier: Modifier) = Text(text = "Forgot password?", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4EA8E9), modifier = modifier)

@Composable
fun ButtonLoginItem(enabled: Boolean, modifier: Modifier) = Button(
    onClick = { /*TODO*/ },
    enabled = enabled,
    modifier = modifier,
    colors = ButtonDefaults.buttonColors(
        containerColor = Color(0xFF4EA8E9),
        contentColor = Color.White,
        disabledContainerColor = Color(0xFF78C8F9),
        disabledContentColor = Color.White
    )
) {
    Text(text = "Log in")
}

@Composable
fun DividerLoginItem() {
    val color = 0xFFF9F9F9
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Divider(
            Modifier
                .background(Color(color))
                .height(1.dp)
                .weight(1f))
        Text(text = "OR", modifier = Modifier.padding(horizontal = 12.dp), fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFFB5B5B5))
        Divider(
            Modifier
                .background(Color(color))
                .height(1.dp)
                .weight(1f))
    }
}

@Composable
fun SocialLoginItem() {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
        Image(painter = painterResource(id = R.drawable.fb), contentDescription = "login facebook", modifier = Modifier.size(20.dp))
        Text(text = "Continue Osvaldo", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color(0xFF4EA8E9), modifier = Modifier.padding(horizontal = 8.dp))
    }
}

fun enabledButtonLogin(email: String, password: String) : Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length >= 6