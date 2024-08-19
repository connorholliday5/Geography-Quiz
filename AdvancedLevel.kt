package com.example.project1geography.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.project1geography.FlagAndCountries
import com.example.project1geography.R
// class to add the timer from the homepage
class AdvancedLevel : ComponentActivity() {
    private val timerViewModel: TimerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                val navController = rememberNavController() // Obtain NavHostController
                AdvancedLevel(navController, timerViewModel)
            }
        }
    }
}
// function that connected the game with the homepage and the back button to go back to the homepage
@Composable
fun AdvancedLevel(navController: NavHostController, timerViewModel: TimerViewModel) {
    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Advanced Level", style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
        )

        )
        Text(text = "Timer: ${timerViewModel.liveElapsedTime.value} seconds")
        Advanced(timerViewModel = timerViewModel)
    }
    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start
    ){
        Button(onClick = {
            navController.navigate(route = "HomePage") })
        {
            Text(text = "Back")

        }

    }
}

@Composable
fun Advanced(timerViewModel: TimerViewModel = remember { TimerViewModel() }) {
    // list of flags and their names
    val flagAndCountries: List<FlagAndCountries> = listOf(
        FlagAndCountries(R.drawable.af, "Afghanistan"),
        FlagAndCountries(R.drawable.ax, "Åland Islands"),
        FlagAndCountries(R.drawable.al, "Albania"),
        FlagAndCountries(R.drawable.dz, "Algeria"),
        FlagAndCountries(R.drawable.`as`, "American Samoa"),
        FlagAndCountries(R.drawable.ad, "Andorra"),
        FlagAndCountries(R.drawable.ao, "Angola"),
        FlagAndCountries(R.drawable.ai, "Anguilla"),
        FlagAndCountries(R.drawable.aq, "Antarctica"),
        FlagAndCountries(R.drawable.ag, "Antigua and Barbuda"),
        FlagAndCountries(R.drawable.ar, "Argentina"),
        FlagAndCountries(R.drawable.am, "Armenia"),
        FlagAndCountries(R.drawable.aw, "Aruba"),
        FlagAndCountries(R.drawable.au, "Australia"),
        FlagAndCountries(R.drawable.at, "Austria"),
        FlagAndCountries(R.drawable.az, "Azerbaijan"),
        FlagAndCountries(R.drawable.bs, "Bahamas"),
        FlagAndCountries(R.drawable.bh, "Bahrain"),
        FlagAndCountries(R.drawable.bd, "Bangladesh"),
        FlagAndCountries(R.drawable.bb, "Barbados"),
        FlagAndCountries(R.drawable.by, "Belarus"),
        FlagAndCountries(R.drawable.be, "Belgium"),
        FlagAndCountries(R.drawable.bz, "Belize"),
        FlagAndCountries(R.drawable.bj, "Benin"),
        FlagAndCountries(R.drawable.bm, "Bermuda"),
        FlagAndCountries(R.drawable.bt, "Bhutan"),
        FlagAndCountries(R.drawable.bo, "Bolivia"),
        FlagAndCountries(R.drawable.ba, "Bosnia and Herzegovina"),
        FlagAndCountries(R.drawable.bw, "Botswana"),
        FlagAndCountries(R.drawable.br, "Brazil"),
        FlagAndCountries(R.drawable.io, "British Indian Ocean Territory"),
        FlagAndCountries(R.drawable.bn, "Brunei"),
        FlagAndCountries(R.drawable.bg, "Bulgaria"),
        FlagAndCountries(R.drawable.bf, "Burkina Faso"),
        FlagAndCountries(R.drawable.bi, "Burundi"),
        FlagAndCountries(R.drawable.kh, "Cambodia"),
        FlagAndCountries(R.drawable.cm, "Cameroon"),
        FlagAndCountries(R.drawable.ca, "Canada"),
        FlagAndCountries(R.drawable.cv, "Cabo Verde"),
        FlagAndCountries(R.drawable.ky, "Cayman Islands"),
        FlagAndCountries(R.drawable.cf, "Central African Republic"),
        FlagAndCountries(R.drawable.td, "Chad"),
        FlagAndCountries(R.drawable.cl, "Chile"),
        FlagAndCountries(R.drawable.cn, "China"),
        FlagAndCountries(R.drawable.cx, "Christmas Island"),
        FlagAndCountries(R.drawable.cc, "Cocos (Keeling) Islands"),
        FlagAndCountries(R.drawable.co, "Colombia"),
        FlagAndCountries(R.drawable.km, "Comoros"),
        FlagAndCountries(R.drawable.cg, "Congo (Brazzaville)"),
        FlagAndCountries(R.drawable.cd, "Congo (Kinshasa)"),
        FlagAndCountries(R.drawable.ck, "Cook Islands"),
        FlagAndCountries(R.drawable.cr, "Costa Rica"),
        FlagAndCountries(R.drawable.hr, "Croatia"),
        FlagAndCountries(R.drawable.cu, "Cuba"),
        FlagAndCountries(R.drawable.cy, "Cyprus"),
        FlagAndCountries(R.drawable.cz, "Czechia"),
        FlagAndCountries(R.drawable.dk, "Denmark"),
        FlagAndCountries(R.drawable.dj, "Djibouti"),
        FlagAndCountries(R.drawable.dm, "Dominica"),
        FlagAndCountries(R.drawable.resource_do, "Dominican Republic"),
        FlagAndCountries(R.drawable.ec, "Ecuador"),
        FlagAndCountries(R.drawable.eg, "Egypt"),
        FlagAndCountries(R.drawable.sv, "El Salvador"),
        FlagAndCountries(R.drawable.gq, "Equatorial Guinea"),
        FlagAndCountries(R.drawable.er, "Eritrea"),
        FlagAndCountries(R.drawable.ee, "Estonia"),
        FlagAndCountries(R.drawable.sz, "Eswatini"),
        FlagAndCountries(R.drawable.et, "Ethiopia"),
        FlagAndCountries(R.drawable.fk, "Falkland Islands"),
        FlagAndCountries(R.drawable.fo, "Faroe Islands"),
        FlagAndCountries(R.drawable.fj, "Fiji"),
        FlagAndCountries(R.drawable.fi, "Finland"),
        FlagAndCountries(R.drawable.fr, "France"),
        FlagAndCountries(R.drawable.pf, "French Polynesia"),
        FlagAndCountries(R.drawable.tf, "French Southern Territories"),
        FlagAndCountries(R.drawable.ga, "Gabon"),
        FlagAndCountries(R.drawable.gm, "Gambia"),
        FlagAndCountries(R.drawable.ge, "Georgia"),
        FlagAndCountries(R.drawable.de, "Germany"),
        FlagAndCountries(R.drawable.gh, "Ghana"),
        FlagAndCountries(R.drawable.gi, "Gibraltar"),
        FlagAndCountries(R.drawable.gr, "Greece"),
        FlagAndCountries(R.drawable.gl, "Greenland"),
        FlagAndCountries(R.drawable.gd, "Grenada"),
        FlagAndCountries(R.drawable.gp, "Guadeloupe"),
        FlagAndCountries(R.drawable.gu, "Guam"),
        FlagAndCountries(R.drawable.gt, "Guatemala"),
        FlagAndCountries(R.drawable.gg, "Guernsey"),
        FlagAndCountries(R.drawable.gn, "Guinea"),
        FlagAndCountries(R.drawable.gw, "Guinea-Bissau"),
        FlagAndCountries(R.drawable.gy, "Guyana"),
        FlagAndCountries(R.drawable.ht, "Haiti"),
        FlagAndCountries(R.drawable.hm, "Heard and McDonald Islands"),
        FlagAndCountries(R.drawable.va, "Vatican City"),
        FlagAndCountries(R.drawable.hn, "Honduras"),
        FlagAndCountries(R.drawable.hk, "Hong Kong"),
        FlagAndCountries(R.drawable.hu, "Hungary"),
        FlagAndCountries(R.drawable.`is`, "Iceland"),
        FlagAndCountries(R.drawable.`in`, "India"),
        FlagAndCountries(R.drawable.id, "Indonesia"),
        FlagAndCountries(R.drawable.ir, "Iran"),
        FlagAndCountries(R.drawable.iq, "Iraq"),
        FlagAndCountries(R.drawable.ie, "Ireland"),
        FlagAndCountries(R.drawable.im, "Isle of Man"),
        FlagAndCountries(R.drawable.il, "Israel"),
        FlagAndCountries(R.drawable.it, "Italy"),
        FlagAndCountries(R.drawable.jm, "Jamaica"),
        FlagAndCountries(R.drawable.jp, "Japan"),
        FlagAndCountries(R.drawable.je, "Jersey"),
        FlagAndCountries(R.drawable.jo, "Jordan"),
        FlagAndCountries(R.drawable.kz, "Kazakhstan"),
        FlagAndCountries(R.drawable.ke, "Kenya"),
        FlagAndCountries(R.drawable.ki, "Kiribati"),
        FlagAndCountries(R.drawable.kw, "Kuwait"),
        FlagAndCountries(R.drawable.kg, "Kyrgyzstan"),
        FlagAndCountries(R.drawable.la, "Laos"),
        FlagAndCountries(R.drawable.lv, "Latvia"),
        FlagAndCountries(R.drawable.lb, "Lebanon"),
        FlagAndCountries(R.drawable.ls, "Lesotho"),
        FlagAndCountries(R.drawable.lr, "Liberia"),
        FlagAndCountries(R.drawable.ly, "Libya"),
        FlagAndCountries(R.drawable.li, "Liechtenstein"),
        FlagAndCountries(R.drawable.lt, "Lithuania"),
        FlagAndCountries(R.drawable.lu, "Luxembourg"),
        FlagAndCountries(R.drawable.mo, "Macao"),
        FlagAndCountries(R.drawable.mg, "Madagascar"),
        FlagAndCountries(R.drawable.mw, "Malawi"),
        FlagAndCountries(R.drawable.my, "Malaysia"),
        FlagAndCountries(R.drawable.mv, "Maldives"),
        FlagAndCountries(R.drawable.ml, "Mali"),
        FlagAndCountries(R.drawable.mt, "Malta"),
        FlagAndCountries(R.drawable.mh, "Marshall Islands"),
        FlagAndCountries(R.drawable.mr, "Mauritania"),
        FlagAndCountries(R.drawable.mu, "Mauritius"),
        FlagAndCountries(R.drawable.mx, "Mexico"),
        FlagAndCountries(R.drawable.fm, "Micronesia"),
        FlagAndCountries(R.drawable.md, "Moldova"),
        FlagAndCountries(R.drawable.mc, "Monaco"),
        FlagAndCountries(R.drawable.mn, "Mongolia"),
        FlagAndCountries(R.drawable.me, "Montenegro"),
        FlagAndCountries(R.drawable.ms, "Montserrat"),
        FlagAndCountries(R.drawable.ma, "Morocco"),
        FlagAndCountries(R.drawable.mz, "Mozambique"),
        FlagAndCountries(R.drawable.mm, "Myanmar"),
        FlagAndCountries(R.drawable.na, "Namibia"),
        FlagAndCountries(R.drawable.nr, "Nauru"),
        FlagAndCountries(R.drawable.np, "Nepal"),
        FlagAndCountries(R.drawable.nl, "Netherlands"),
        FlagAndCountries(R.drawable.nz, "New Zealand"),
        FlagAndCountries(R.drawable.ni, "Nicaragua"),
        FlagAndCountries(R.drawable.ne, "Niger"),
        FlagAndCountries(R.drawable.ng, "Nigeria"),
        FlagAndCountries(R.drawable.nu, "Niue"),
        FlagAndCountries(R.drawable.kp, "North Korea"),
        FlagAndCountries(R.drawable.nf, "Norfolk Island"),
        FlagAndCountries(R.drawable.mp, "Northern Mariana Islands"),
        FlagAndCountries(R.drawable.no, "Norway"),
        FlagAndCountries(R.drawable.om, "Oman"),
        FlagAndCountries(R.drawable.pk, "Pakistan"),
        FlagAndCountries(R.drawable.pw, "Palau"),
        FlagAndCountries(R.drawable.ps, "Palestine"),
        FlagAndCountries(R.drawable.pa, "Panama"),
        FlagAndCountries(R.drawable.pg, "Papua New Guinea"),
        FlagAndCountries(R.drawable.py, "Paraguay"),
        FlagAndCountries(R.drawable.pe, "Peru"),
        FlagAndCountries(R.drawable.ph, "Philippines"),
        FlagAndCountries(R.drawable.pn, "Pitcairn Islands"),
        FlagAndCountries(R.drawable.pl, "Poland"),
        FlagAndCountries(R.drawable.pt, "Portugal"),
        FlagAndCountries(R.drawable.pr, "Puerto Rico"),
        FlagAndCountries(R.drawable.qa, "Qatar"),
        FlagAndCountries(R.drawable.mk, "Republic of North Macedonia"),
        FlagAndCountries(R.drawable.ro, "Romania"),
        FlagAndCountries(R.drawable.ru, "Russia"),
        FlagAndCountries(R.drawable.rw, "Rwanda"),
        FlagAndCountries(R.drawable.sh, "Saint Helena"),
        FlagAndCountries(R.drawable.kn, "Saint Kitts and Nevis"),
        FlagAndCountries(R.drawable.lc, "Saint Lucia"),
        FlagAndCountries(R.drawable.vc, "Saint Vincent and the Grenadines"),
        FlagAndCountries(R.drawable.ws, "Samoa"),
        FlagAndCountries(R.drawable.sm, "San Marino"),
        FlagAndCountries(R.drawable.st, "São Tomé and Príncipe"),
        FlagAndCountries(R.drawable.sa, "Saudi Arabia"),
        FlagAndCountries(R.drawable.sn, "Senegal"),
        FlagAndCountries(R.drawable.rs, "Serbia"),
        FlagAndCountries(R.drawable.sc, "Seychelles"),
        FlagAndCountries(R.drawable.sl, "Sierra Leone"),
        FlagAndCountries(R.drawable.sg, "Singapore"),
        FlagAndCountries(R.drawable.sx, "Sint Maarten"),
        FlagAndCountries(R.drawable.sk, "Slovakia"),
        FlagAndCountries(R.drawable.si, "Slovenia"),
        FlagAndCountries(R.drawable.sb, "Solomon Islands"),
        FlagAndCountries(R.drawable.so, "Somalia"),
        FlagAndCountries(R.drawable.kr, "South Korea"),
        FlagAndCountries(R.drawable.za, "South Africa"),
        FlagAndCountries(R.drawable.gs, "South Georgia and the South Sandwich Islands"),
        FlagAndCountries(R.drawable.ss, "South Sudan"),
        FlagAndCountries(R.drawable.es, "Spain"),
        FlagAndCountries(R.drawable.lk, "Sri Lanka"),
        FlagAndCountries(R.drawable.sd, "Sudan"),
        FlagAndCountries(R.drawable.sr, "Suriname"),
        FlagAndCountries(R.drawable.sj, "Svalbard and Jan Mayen"),
        FlagAndCountries(R.drawable.se, "Sweden"),
        FlagAndCountries(R.drawable.ch, "Switzerland"),
        FlagAndCountries(R.drawable.sy, "Syria"),
        FlagAndCountries(R.drawable.tw, "Taiwan"),
        FlagAndCountries(R.drawable.tj, "Tajikistan"),
        FlagAndCountries(R.drawable.tz, "Tanzania"),
        FlagAndCountries(R.drawable.th, "Thailand"),
        FlagAndCountries(R.drawable.tl, "Timor-Leste"),
        FlagAndCountries(R.drawable.tg, "Togo"),
        FlagAndCountries(R.drawable.tk, "Tokelau"),
        FlagAndCountries(R.drawable.to, "Tonga"),
        FlagAndCountries(R.drawable.tt, "Trinidad and Tobago"),
        FlagAndCountries(R.drawable.tn, "Tunisia"),
        FlagAndCountries(R.drawable.tr, "Turkey"),
        FlagAndCountries(R.drawable.tm, "Turkmenistan"),
        FlagAndCountries(R.drawable.tc, "Turks and Caicos Islands"),
        FlagAndCountries(R.drawable.tv, "Tuvalu"),
        FlagAndCountries(R.drawable.ug, "Uganda"),
        FlagAndCountries(R.drawable.ua, "Ukraine"),
        FlagAndCountries(R.drawable.ae, "United Arab Emirates"),
        FlagAndCountries(R.drawable.gb, "United Kingdom"),
        FlagAndCountries(R.drawable.us, "United States"),
        FlagAndCountries(R.drawable.uy, "Uruguay"),
        FlagAndCountries(R.drawable.uz, "Uzbekistan"),
        FlagAndCountries(R.drawable.vu, "Vanuatu"),
        FlagAndCountries(R.drawable.ve, "Venezuela"),
        FlagAndCountries(R.drawable.vn, "Vietnam"),
        FlagAndCountries(R.drawable.wf, "Wallis and Futuna"),
        FlagAndCountries(R.drawable.eh, "Western Sahara"),
        FlagAndCountries(R.drawable.ye, "Yemen"),
        FlagAndCountries(R.drawable.zm, "Zambia"),
        FlagAndCountries(R.drawable.zw, "Zimbabwe")
    )
    // variables to produce random flags and to know if the guess was correct
    // also displays correct answer
    val userInputtedCountries = remember { mutableStateListOf("", "", "") }
    var isCorrect by remember { mutableStateOf(false) }
    var showWrongMessage by remember { mutableStateOf(false) }
    var incorrectGuessCount by remember { mutableIntStateOf(0) }
    var displayAnswer by remember { mutableStateOf(false) }
    var shuffledIndices by remember {
        mutableStateOf(
            (flagAndCountries.indices).shuffled().take(3)
        )
    }
    // shuffles flag and has a scroll bar
    Spacer(modifier = Modifier.height(16.dp))
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),

            ) {
            for (index in 0 until minOf(shuffledIndices.size, 3)) {
                val selectFlagAndCountry = flagAndCountries[shuffledIndices[index]]
                val userAnswer = userInputtedCountries.getOrNull(index) ?: ""


                // Flag Image
                Image(
                    painter = painterResource(id = selectFlagAndCountry.drawableId),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .clip(MaterialTheme.shapes.medium)
                )
// text box to type in flag name
                TextField(
                    value = userAnswer,
                    onValueChange = { newText ->
                        userInputtedCountries[index] = newText
                    },
                    textStyle = TextStyle.Default.copy(
                        color = if (isCorrect) Color.Gray else LocalContentColor.current
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done,
                    ),
                    enabled = !isCorrect,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .border(1.dp, Color.Gray, shape = MaterialTheme.shapes.medium)
                        .background(Color.White),
                )

                // Display correct answer only after clicking "Submit"
                if (showWrongMessage && !isCorrect || timerViewModel.liveElapsedTime.value == 0 && !userAnswer
                        .equals(selectFlagAndCountry.countryName, ignoreCase = true)
                ) {
                    Text(
                        text = "Correct Answer: ${selectFlagAndCountry.countryName}",
                        color = Color.Blue,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(16.dp)
                    )
                }

                // Wrong Message
                if (showWrongMessage && !isCorrect && !userAnswer
                        .equals(selectFlagAndCountry.countryName, ignoreCase = true)
                ) {
                    Text(
                        text = "Wrong!",
                        color = Color.Red,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                if (!isCorrect && userAnswer
                        .equals(selectFlagAndCountry.countryName, ignoreCase = true)
                ) {
                    Text(
                        text = "CORRECT!",
                        color = Color.Green,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(16.dp)
                    )
                }
            }
            var clickedNext by remember { mutableStateOf(false) }

            Button(
                onClick = {
                    val allCorrect = userInputtedCountries.zip(flagAndCountries.take(3))
                        .all { (userInput, flagAndCountry) ->
                            userInput.equals(flagAndCountry.countryName, ignoreCase = true)
                        }

                    if (allCorrect || (showWrongMessage && incorrectGuessCount >= 3)) {
                        // If all answers are correct or incorrect guess count is reached, set clickedNext to true
                        clickedNext = true
                    } else {
                        // Increment incorrect guess count if not all answers are correct
                        incorrectGuessCount++
                        // Set showWrongMessage to true if the user has made 3 incorrect guesses
                        if (incorrectGuessCount >= 3) {
                            showWrongMessage = true
                            displayAnswer = true
                        }
                    }

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                shape = CutCornerShape(8.dp),
            ) {
                Text(if (showWrongMessage || isCorrect ) "Next" else "Submit")
            }


// Reset game state if "Next" is clicked
            if (clickedNext) {
                userInputtedCountries.clear() // Clear user inputs
                userInputtedCountries.addAll(List(3) { "" }) // Reset user inputs to empty
                isCorrect = false // Reset correctness flag
                showWrongMessage = false // Reset wrong message flag
                displayAnswer = false // Reset display answer flag
                incorrectGuessCount = 0 // Reset incorrect guess count


                // Reshuffle indices for the next game
                val randomIndices = (flagAndCountries.indices).shuffled().take(3)
                shuffledIndices = randomIndices.toList()
                clickedNext = false // Reset clickedNext flag after resetting the game state

                if (timerViewModel.liveElapsedTime.value == 0 ){
                    timerViewModel.resetTimer()
                    timerViewModel.startTimer()
                }
            }

        }
    }
}
