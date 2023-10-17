package com.shared.ui.scenes

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.shared.components.DividerFull
import com.shared.theme.B1_16Bold
import com.shared.theme.LargePadding
import com.shared.theme.XLargePadding
import com.shared.utils.rememberKoin
import com.sychev.db.common.MR
import dev.icerock.moko.resources.compose.painterResource
import feature.navigation.api.router.Router
import library.images.painter.rememberPainter

@Composable
fun TestScene(router: Router = rememberKoin()) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier.padding(XLargePadding)
                .clickable { router.goBack() },
            text = "Go back",
        )

        Text(
            modifier = Modifier.padding(XLargePadding),
            text = "This is test scene"
        )

        LazyColumn {
            itemsIndexed(testData, key = { i, item -> item }) { index, item ->
                Column {
                    val painter = rememberPainter(
                        url = item,
                        placeholderPainter = {
                            painterResource(MR.images.placeholder_deafult)
                        },
                        errorPainter = {
                            painterResource(MR.images.placeholder_error)
                        }
                    )
                    Image(
                        modifier = Modifier.fillMaxWidth().height(460.dp).padding(XLargePadding),
                        painter = painter,
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds
                    )
                    Text(
                        modifier = Modifier.padding(XLargePadding),
                        text = "This is item with index $index",
                        style = B1_16Bold,
                    )
                    DividerFull(modifier = Modifier.padding(horizontal = LargePadding))
                }


            }
        }

    }
}

private val testData = listOf(
    "https://i.pinimg.com/564x/1c/16/ad/1c16ad719ad99e0672aea9214ca36650.jpg",
    "https://i.pinimg.com/474x/f5/f4/0c/f5f40cb0a153160e1e59305fdb925f42.jpg",
    "https://i.pinimg.com/474x/b6/d4/77/b6d4777436f5e342113ca0b979f85ad4.jpg",
    "https://i.pinimg.com/474x/7d/da/7a/7dda7a76890aeb263b30b8c54a36d52c.jpg",
    "https://i.pinimg.com/474x/dc/f4/84/dcf4847644f904a47e1332f7c4072cfb.jpg",
    "https://i.pinimg.com/474x/fd/de/60/fdde60404c6241d26e95c18f13d1b990.jpg",
    "https://i.pinimg.com/474x/94/98/f1/9498f1ef09d0a1138af73b32895c3b78.jpg",
    "https://i.pinimg.com/474x/94/d1/8c/94d18cf82f821af7e5959f81d461b2d1.jpg",
    "https://i.pinimg.com/474x/bf/33/61/bf3361e94383d87f10315d916577e75c.jpg",
    "https://i.pinimg.com/474x/3a/64/9a/3a649af94f268d93ea1ef939c2466c96.jpg",
    "https://i.pinimg.com/474x/e9/51/6d/e9516db5ff5414715eb6d840c0d68e46.jpg",
    "https://i.pinimg.com/474x/3c/cd/25/3ccd25637fb3af6a669501d4590a8fbd.jpg",
    "https://i.pinimg.com/474x/ab/9c/ac/ab9cac25495e4416e1eb28400fff552c.jpg",
    "https://i.pinimg.com/474x/fc/57/4f/fc574fec392300006cd52088f63ae749.jpg",
    "https://i.pinimg.com/474x/4d/59/83/4d5983d7dd1c69091c0a4a7686c3bba3.jpg",
    "https://i.pinimg.com/474x/25/81/e5/2581e5bccf646f5cf9ddedb6d6eea556.jpg",
    "https://i.pinimg.com/474x/7c/45/b6/7c45b6c87c12d8739c26feac58f02037.jpg",
    "https://i.pinimg.com/474x/1d/7f/05/1d7f05c8c4ca8721b9c391dba64b793e.jpg",
    "https://i.pinimg.com/474x/14/5d/12/145d127637f67c2b18528d41d67f1c21.jpg",
    "https://i.pinimg.com/474x/d8/20/d9/d820d964369edd270af567b75b1b9c13.jpg",
    "https://i.pinimg.com/474x/5a/9b/6f/5a9b6fb721f441038b695e83b58877c2.jpg",
    "https://i.pinimg.com/474x/e9/a9/56/e9a956e7ef39549992f1224b95a8496c.jpg",
    "https://i.pinimg.com/474x/a6/0c/1b/a60c1bc1dbaa3f0bb47096771095baa8.jpg",
    "https://i.pinimg.com/474x/f4/10/b1/f410b1783a64bef22448fc940d7cc0b8.jpg",
    "https://i.pinimg.com/474x/b0/ae/c1/b0aec17e77505e7928416e67f463f1cd.jpg",
    "https://i.pinimg.com/474x/7e/07/68/7e076845f24fbc290a2bd9102d54f1b6.jpg",
    "https://i.pinimg.com/474x/b5/87/a2/b587a2f76625e5ba6409ad12a59c0eb5.jpg",
    "https://i.pinimg.com/474x/af/96/a8/af96a81342400a7e04a80a428eec316f.jpg",
    "https://i.pinimg.com/474x/f7/cc/59/f7cc59f42c2650c40fe137395a59068e.jpg",
    "https://i.pinimg.com/474x/95/45/ae/9545ae161eeee088ece08056297dca29.jpg",
    "https://i.pinimg.com/474x/3b/f2/cc/3bf2cce3d770680e86b595495399b7bf.jpg",
    "https://i.pinimg.com/474x/40/e2/b4/40e2b4bd05b9cfc6c7aacb29b0f012e0.jpg",
    "https://i.pinimg.com/474x/d2/fe/8d/d2fe8db96220183458eaf23215008ee1.jpg",
    "https://i.pinimg.com/474x/5c/b5/9e/5cb59e2e883ef769ba88c602b6a83c01.jpg",
    "https://i.pinimg.com/474x/ec/fe/ee/ecfeee039a89ad7486a359fc21475287.jpg",
    "https://i.pinimg.com/474x/0a/08/88/0a08888dd023c9975abc54558fd1a3b4.jpg",
    "https://i.pinimg.com/474x/be/ea/82/beea82af545d0fa67982fa0c25ba31c8.jpg",
    "https://i.pinimg.com/474x/fa/82/ba/fa82ba25df6ab2c0b12cae18e944df34.jpg",
    "https://i.pinimg.com/474x/84/69/ca/8469ca08f2a0b6be70818ce93f884835.jpg",
    "https://i.pinimg.com/474x/17/b4/58/17b45809377c9970042a0940662fc22f.jpg",
    "https://i.pinimg.com/474x/1d/93/26/1d9326c96f1a9770a8880792b08a897b.jpg",
    "https://i.pinimg.com/474x/a3/56/4a/a3564aa833c35f3203bde57db1b17c58.jpg",
    "https://i.pinimg.com/474x/b8/b1/b4/b8b1b44d7d53335a1103d7ef633f353d.jpg",
    "https://i.pinimg.com/474x/f9/cf/a8/f9cfa8d0dfeda93600777b91c92734f0.jpg",
    "https://i.pinimg.com/474x/20/df/df/20dfdf41c65d83ac3e997ef48694a84b.jpg",
    "https://i.pinimg.com/474x/9e/42/81/9e4281322087e62794a64d3f7d5c0b30.jpg",
    "https://i.pinimg.com/474x/91/88/82/918882dcb3cc9bc9a99061a109833281.jpg",
    "https://i.pinimg.com/474x/2d/a7/85/2da78578df46c3c4ad41e6b3cac51e0c.jpg",
    "https://i.pinimg.com/474x/ee/61/2e/ee612e8a8c7fa6c9656c15196e462410.jpg",
    "https://i.pinimg.com/474x/ed/51/3d/ed513d0c213a8f88bec21fab2b04dc6c.jpg",
    "https://i.pinimg.com/474x/de/28/cb/de28cb9166d4af41245459c8e7b7e5fc.jpg",
    "https://i.pinimg.com/474x/4a/fa/46/4afa46daacc14fa224ebf09ad2a1ceee.jpg",
    "https://i.pinimg.com/474x/12/26/9d/12269dd8fdc115ef3d1b28af8d9cc695.jpg",
)