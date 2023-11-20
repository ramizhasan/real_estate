package com.prettier.utils.objects;

import com.prettier.entity.concretes.Advert;
import com.prettier.entity.concretes.AdvertType;
import com.prettier.entity.enums.Status;
import com.prettier.repository.AdvertRepository;
import com.prettier.repository.AdvertTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
public class AdvertObj {

    private final AdvertRepository advertRepository;
    private final AdvertTypeObj advertTypeObj;


    public Advert createAdvertIstanbul() {
        return Advert.builder()
                .title("Harika konumda 3+1")
                .desc("Tarabyada kentsel donusume uygun yatirmlik, icinede kiralarini duzenli odeyen kiraci oturmakta olup istenilmesi halinde 2 ay icerisinde evi teslim edecektir,")
                .slug("harika-konumda-3-1")
                .price(3500000.00)
                .status(Status.PENDING)
                .builtIn(false)
                .isActive(false)
                .viewCount(10)
                .location("tarbya123456789")
                .advertType(advertTypeObj.createHousing())
                .build();
    }

    public Advert createAdvertIzmir() {
        return Advert.builder()
                .title("Tef yyapi guvencesi ile cok uygun fiyata sizde ev sahibi olun")
                .desc("Menemen 2 nci etapta sizde hayallerinizi gerceklestirin. Kira oder gibi sizde evinizin sahibi olun, Yasam alanlari ile kendinize deger katin, sehrin yogunlugundan uzakta, doga ile basbasa bir hayata adim atmak icin sizleri satis ofisimize bekiyoruz,")
                .slug("hayallerinizin-evi-doga")
                .price(9500000.00)
                .status(Status.ACTIVATED)
                .builtIn(true)
                .isActive(true)
                .viewCount(30)
                .location("menemen123456")
                .advertType(advertTypeObj.createHousing())
                .build();
    }

    public Advert createAdvertAnkara() {
        return Advert.builder()
                .title("Muhteşem villa")
                .desc("Site içinde güvenli tribleks villa kendine özel bahçesi ve garajı mevcut.Temiz havası doğal güzelliğiyle eşsiz bir villa SADECE ARAÇ TAKASI OLUR")
                .slug("emlak-konut-satilik-muhtesem-villa-701439909")
                .price(6500000.00)
                .status(Status.REJECTED)
                .builtIn(false)
                .isActive(true)
                .viewCount(20)
                .location("Ankara/Cankaya/Cayyolu")
                .advertType(advertTypeObj.createHousing())
                .build();
    }
    public Advert createAdvertEskisehir() {
        return Advert.builder()
                .title("İMPARATOR EMLAKTAN ERTAŞ CADDE YAKININDA ASANSÖRLÜ E.BANYOLU 3+1")
                .desc("İMPARATOR EMLAKTAN EMEK MAHALLESİNDE ERTAŞ CADDE YAKININDA 3+1 DAİRE \n" +
                        "\n" +
                        "Emek mahallesinde, Mükemmel konumda  \n" +
                        "\u200BDairemiz brüt 125m2 dir.\n" +
                        "Kat seçenekleri mevcuttur\n" +
                        "Ortak kapalı garaj, Cam balkon \n" +
                        "Ebeveyn banyo, Asansör, led spot \n" +
                        "Ankastre set, kombili, portmanto\n" +
                        "Otobüs, tramvay, Market, pazar çok yakındır \n" +
                        "Mantıklı araç ve daire takasları değerlendirilir")
                .slug("emlak-konut-satilik-imparator-emlaktan-ertas-cadde-yakininda-asansorlu-e.banyolu-3-plus1-1136104585")
                .price(2300000.00)
                .status(Status.ACTIVATED)
                .builtIn(false)
                .isActive(true)
                .viewCount(20)
                .location("Eskisehir/Odunpazari/Emek mahallesi")
                .advertType(advertTypeObj.createHousing())
                .build();
    }
    public void fillAdvertRepository() {
        advertRepository.saveAll(List.<Advert>of(createAdvertIstanbul(),createAdvertAnkara()
        , createAdvertEskisehir(), createAdvertIzmir()));
    }

}
