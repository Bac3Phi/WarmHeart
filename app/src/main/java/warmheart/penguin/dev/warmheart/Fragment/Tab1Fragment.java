package warmheart.penguin.dev.warmheart.Fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import warmheart.penguin.dev.warmheart.Adapter.RecyclerViewDataAdapter;
import warmheart.penguin.dev.warmheart.Model.SectionDataModel;
import warmheart.penguin.dev.warmheart.Model.SingleItemModel;
import warmheart.penguin.dev.warmheart.R;

/**
 * Created by Administrator on 23/11/2017.
 */

public class Tab1Fragment extends android.support.v4.app.Fragment {
    ArrayList<SectionDataModel> allSampleData;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tab1, container, false);

        allSampleData = new ArrayList<SectionDataModel>();

        //createDummyData();
        addSelection1Data();
        addSelection2Data();
        addSelection3Data();
        addSelection4Data();
        addSelection5Data();

        RecyclerView my_recycler_view = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);

        my_recycler_view.setHasFixedSize(true);

        RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(this.getContext(), allSampleData);

        my_recycler_view.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));

        my_recycler_view.setAdapter(adapter);


        return rootView;
    }

    private void createDummyData() {

        for (int i = 1; i <= 5; i++) {

            SectionDataModel dm = new SectionDataModel();

            dm.setHeaderTitle("Section " + i);

            ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();
            for (int j = 0; j <= 5; j++) {
                singleItem.add(new SingleItemModel("Item " + j, "URL " + j));

            }
        //    singleItem.set(1,new SingleItemModel("Phi","https://i.imgur.com/T9j4P5N.jpg"));
            dm.setAllItemsInSection(singleItem);

            allSampleData.add(dm);

        }

    }
    public void addSelection1Data()
    {
       SectionDataModel dm = new SectionDataModel();
        ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();
        dm.setHeaderTitle("Những mảnh đời bất hạnh");
        singleItem.add(new SingleItemModel("Sưởi ấm trái tim",
                "https://i.imgur.com/QUeD13E.jpg",
                "Từ xưa tới nay người Việt Nam chúng ta luôn thể hiện tinh thần đùm bọc, thương yêu, giúp đỡ lẫn nhau qua những câu ca dao, tục ngữ như:\"Thương người như thể thương thân\", \"Lá lành đùm lá rách\" hay \"Một miếng khi đói bằng cả gói khi no\".\n" +
                        "Trong cuộc sống hàng ngày của chúng ta luôn quẩn quanh đâu đó những mảnh đời cơ cực, khốn khó, biết bao những hoàn cảnh, những con người phải vật lộn với bệnh tật từng ngày, từng giờ để vượt qua những đau đớn tột cùng.\n" +
                        "\n" +
                        "Biết bao cụ già neo đơn không người chăm sóc, biết bao em nhỏ không cha không mẹ mong được cắp sách tới trường, ...họ đã và đang phải chấp nhận cuộc sống thiếu thốn cả về tinh thần và vật chất... Với những hoàn cảnh như vậy họ đang và rất cần, cần lắm những tấm lòng, những tình cảm của chúng ta. Không chỉ vật chất mới gọi là từ thiện là giúp đỡ, mà đơn giản chỉ là 1 vòng tay yêu thương, nhưng cử chỉ bé nhỏ xuất phát từ trong tâm chúng ta như vậy cũng đủ cảm thấy ấm lòng.\n" +
                        "Và một trong những hoàn cảnh như vậy là gia đình anh Nguyễn Văn Chung và chị Nguyễn Thị Thủy ở Đội 1, thôn Văn Lâm, xã Liêm Tiết, huyện Thanh Liêm, tỉnh Hà Nam. \n" +
                        "Nhận được nguồn tin về hoàn cảnh gia đình anh/chị chúng tôi đã đến thăm gia đình vào một buổi xế chiều. Dù đã tìm hiểu và biết trước về hoàn cảnh nhưng tôi không khỏi giật mình, ngỡ ngàng khi bước chân vào căn nhà nhỏ. Khi bước vào nhà chị, nghe tiếng trẻ nhỏ ú ớ không thành tiếng. Cảnh tượng trước mặt là hai em nằm bò dài trên giường, khi thấy chúng tôi các bé bò nhoài người ra ú ớ, các em muốn được bế, các em làm nũng và có lẽ các em muốn nói gì đó, có lẽ các em muốn có thể tiến về phía chúng tôi, nhưng mọi sự cố gắng của các em chi là những âm thanh không thành tiếng, là những cái rướn người về phía trước. Mặc dù đã 8, 9tuổi rồi nhưng các em cũng chưa 1 lần cất tiếng gọi bố, gọi mẹ. Các em cũng không thể tự bước đi trên đôi chân bé nhỏ của mình. Mọi sinh hoạt của các em đều phụ thuộc vào mẹ từ việc ăn uống, vệ sinh tất cả những việc đó, những việc đơn giản nhất mà mỗi chúng ta ai cũng có thể làm, còn các em thì không thể\n",
                "thôn Văn Lâm, xã Liêm Tiết, huyện Thanh Liêm, tỉnh Hà Nam",
                "16Pm"));
        singleItem.add(new SingleItemModel("Chồng tật nguyền nuôi vợ trọng bệnh và con thơ dại",
                "https://i.imgur.com/79VikJ0.jpg",
                "Mặc dù bản thân không được lành lặn như người ta khi mắc chứng bệnh vôi hóa cột sống, cái lưng còng rạp nhưng hàng ngày vẫn đầu tắt mặt tối với đồng ruộng...\n" +
                        "Mặc dù bản thân không được lành lặn như người ta khi mắc chứng bệnh vôi hóa cột sống, cái lưng còng rạp nhưng hàng ngày vẫn đầu tắt mặt tối với đồng ruộng, đảm nhận luôn cả việc ngồi khâu nón thuê thâu đêm để kiếm 50 nghìn đồng mỗi ngày chăm sóc cho người vợ bị bệnh suy tim độ II và suy thận độ III và nuôi 3 đứa con ăn học. Đó là anh Nguyễn Văn Sơn (SN 1966) ở thôn Văn La, xã Văn Võ, huyện Chương Mỹ, thành phố Hà Nội.  \n" +
                        "Chăm vợ bệnh nặng, ba con thơ dại\n" +
                        "Căn nhà nhỏ cấp bốn rêu mốc nằm lọt thỏm ở tận cuối con mương sâu hun hút nơi cuối làng, khi tôi đến đã quá 12 giờ trưa nhưng cả nhà 5 người vẫn chưa ai ăn gì. Mâm cơm đạm bạc độc đĩa rau muống, bát nước mắm và chút muối vừng, người đàn ông gầy rộc, còng rạp cả lưng bảo: “Cô ấy (vợ anh Sơn) còn đang nằm mệt nằm kia chưa ăn uống được gì nên cả nhà không ai ăn được, lát cô ấy dậy thì bố con tôi mới ăn\".\n",
                "thôn Văn La, xã Văn Võ, huyện Chương Mỹ, thành phố Hà Nội.  ",
                "20PM"));
        singleItem.add(new SingleItemModel("Éo le những trái tim lỡ nhịp",
                "https://i.imgur.com/8oIGCKR.jpg",
                "Hai bé Nguyễn Quý Hiệp (SN 2007) và Nguyễn Khánh Ly (SN 2009) từ khi sinh ra đã mang trong mình căn bệnh tim quái ác, Hiệp còn bị dị dạng xương lồng ngực, bé Ly thì bị loạn thị mắt chỉ còn 2/10.\n" +
                        "Trớ trêu thay, năm 2016 người mẹ tảo tần của hai em qua đời đột ngột, mới đây bố bị ngã giàn giáo gãy chân phải điều trị mất 3 tháng. Với hai đứa trẻ, đó là chuỗi ngày xót xa...\n" +
                        "Không khó để tìm được nhà của bà Đỗ Thị Thủy (bà nội 2 bé) ở xóm Cống, thôn Ngọc Than, xã Ngọc Mỹ, huyện Quốc Oai, Hà Nội. Bởi đi đến đâu hỏi, dân làng ai cũng biết đến gia đình đặc biệt này. Căn nhà hơn chục mét vuông, trước là nơi sinh hoạt của 6 người nay đã được dỡ bỏ chỉ để lại mảnh đất trống hoác, bộ bàn ghế ọp ẹp đặt ngay giữa sân nhà thờ họ trở thành nơi tiếp khách.\n",
                "thôn Ngọc Than, xã Ngọc Mỹ, huyện Quốc Oai, Hà Nội.",
                "7AM"));
        dm.setAllItemsInSection(singleItem);
        allSampleData.add(dm);
    }

    public void addSelection2Data(){
        SectionDataModel dm = new SectionDataModel();
        ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();
        dm.setHeaderTitle("Nhà Tình Thương");
        singleItem.add(new SingleItemModel("Công ty Cổ phần Khu công nghiệp Hiệp Phước trao tặng nhà tình thương",
                "https://i.imgur.com/mpm46y7.jpg",
                "Sáng ngày 06/07/2017, đại diện Công ty Cổ phần Khu công nghiệp Hiệp Phước (HIPC) đã phối hợp với chính quyền địa phương xã Long Thới tổ chức trao tặng nhà tình thương cho gia đình ông Nguyễn Văn Xem, sinh năm 1950  tại ấp 2, xã Long Thới, huyện Nhà Bè, TP Hồ Chí Minh.\n" +
                        "Nhà tình thương cấp 4 với diện tích xây dựng 40m2, được thiết kế nhỏ nhắn, phù hợp với đời sống sinh hoạt hàng ngày. Gia đình ông Nguyễn Văn Xem là một trong những hộ dân có hoàn cảnh rất khó khăn tại xã Long Thới. Kinh phí xây dựng căn nhà 50 triệu đồng được Công ty Cổ phần Khu công nghiệp Hiệp Phước tài trợ. Việc trao tặng nhà tình thương sẽ góp phần giúp gia đình Ông Nguyễn Văn Xem có nhà ở ổn định và yên tâm lao động tốt hơn để thoát nghèo.\n" +
                        "Đến dự buổi lễ trao nhà tình thương có đại diện phía Công ty CP KCN Hiệp Phước - Ông Nguyễn Tấn Phong, Phó TGĐ, lãnh đạo các phòng ban Công ty, đại diện xã Long Thới cùng gia đình Ông Nguyễn Văn Xem.\n" +
                        "Đây là một trong nhiều hoạt động vì cộng đồng xã hội cao đẹp Công ty đã và đang thực hiện để sẻ chia, gia tăng sự quan tâm, chăm lo đến các hộ nghèo theo chiến dịch vận động vì người nghèo của Thành phố Hồ Chí Minh.\n",
                "xã Long Thới, huyện Nhà Bè, TP Hồ Chí Minh.",
                "12/07/2017"));
        singleItem.add(new SingleItemModel("Tặng hàng trăm ngôi nhà cho dân nghèo vùng lũ",
                "https://i.imgur.com/IENutBY.jpg",
                "133 ngôi nhà tình thương đã được xây mới hoặc sửa chữa lại cho người nghèo vùng bị thiệt hại do thiên tai tại các tỉnh miền Trung - Tây Nguyên như Quảng Ngãi, Đà Nẵng, Kon Tum...\n" +
                        "Chương trình do Tổ chức Đông Tây hội ngộ phối hợp với UBND các địa phương triển khai, với tổng vốn đầu tư 130.000 USD.\n" +
                        "Sáng 31/12, tám ngôi nhà tình thương đã được bàn giao cho những gia đình ở xã Tịnh Kỳ, huyện Sơn Tịnh, Quảng Ngãi; kết thúc chương trình hỗ trợ nhà ở cho người dân vùng ảnh hưởng thiên tai trong năm 2010.\n" +
                        "Gần 200 suất quà và tiền mặt cũng được Tổng Công ty cổ phần bảo hiểm dầu khí Việt Nam tặng cho người dân vùng lũ huyện Bình Sơn, nhân dịp đón Tết dương lịch.\n",
                "xã Tịnh Kỳ, huyện Sơn Tịnh, Quảng Ngãi",
                "16Pm 20/12/2015"));
        singleItem.add(new SingleItemModel("Ban Tuyên giáo TP.HCM tặng nhà tình nghĩa, tình thương ở Bình Chánh",
                "https://i.imgur.com/YiGOJCH.jpg",
                "TTO - Chiều 30-8, đoàn công tác của Ban Tuyên giáo Thành ủy TP.HCM đã tổ chức lễ trao 2 nhà tình nghĩa, tình thương tại huyện Bình Chánh, TP.HCM. Nhà tình nghĩa của ông Nguyễn Văn Lễ (thương binh 3/4) ở xã Hưng Long có diện tích 32m2, chi phí xây dựng trên 70 triệu đồng.\n" +
                        "Nhà tình thương của ông Lê Trường Thanh, ở xã Phạm Văn Hai có diện tích 50m2, chi phí xây dựng trên 50 triệu đồng.\n" +
                        "Hai căn nhà được xây tường, lót gạch men và lợp tôn. Chi phí xây nhà và quà tặng do Công ty Xổ số kiến thiết TP.HCM tài trợ.\n",
                "thôn Văn Lâm, xã Liêm Tiết, huyện Thanh Liêm, tỉnh Hà Nam",
                "Chiều 30-8-2017"));
        dm.setAllItemsInSection(singleItem);
        allSampleData.add(dm);
    }

    public void addSelection3Data() {
        SectionDataModel dm = new SectionDataModel();
        ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();
        dm.setHeaderTitle("Cơm Từ Thiện");
        singleItem.add(new SingleItemModel("Cơm từ thiện chợ Lái Thiêu",
                "https://i.imgur.com/ETsS0P9.jpg",
                "Trong các buổi trưa đầu tháng 3-2011, tôi thường đến bếp ăn từ thiện xã hội này để gặp những người lao động nghèo quanh khu vực chợ Lái Thiêu. Nhìn nét mặt tần tảo của những người nghèo xa quê đến đây mưu sinh vui cười bên những phần ăn trưa miễn phí, tôi càng thấm thía câu nói “Một miếng khi đói bằng một gói khi no”. Họ đã thật sự được chia sẻ những gánh nặng trong cuộc sống mưu sinh nơi đất khách quê người.\n" +
                        " Vào những bữa ăn trưa, chúng tôi chứng kiến hàng trăm người nghèo mưu sinh bằng nghề bán vé số, buôn gánh bán bưng tập hợp tại đây để ăn trưa miễn phí do những người tình nguyện Tổ Nhân đạo Thiện Hòa thực hiện mới cảm thấy ấm áp tình người. Chị Đặng Thị Quới, quê Mộ Đức, Quảng Ngãi tâm sự: “Tôi vào bán vé số dạo tại khu vực chợ Lái Thiêu đã được hơn 2 năm nay. Khi hay tin trên đường Ngô Quyền có phát cơm từ thiện xã hội miễn phí, những người bán vé số dạo như chúng tôi ai nấy cũng vui mừng, nhất là từ sau Tết, khi giá cả những bữa cơm cho người nghèo cũng nhích giá từ 2.000 - 5.000 đồng”.\n",
                "chợ Lái Thiêu",
                "11AM"));
        singleItem.add(new SingleItemModel("Cơm từ thiện bệnh viện đa khoa",
                "https://i.imgur.com/h0nr5M0.jpg",
                "Đi vào hoạt động từ tháng 12 năm 2009, đến nay Bếp ăn tình thương tổ nhân đạo Thiện Hòa đã trở thành một địa chỉ quen thuộc và đáng tin cậy của các bệnh nhân nghèo đang điều trị ở Bệnh viện đa khoa Thị Xã Thuận An. Hoạt động với chức năng là một tổ chức nhân đạo dân lập, từ sự đóng góp tự nguyện của các mạnh thường quân, Từ thiện Thiện Hòa đã thành lập Bếp ăn từ thiện trong bệnh viện để cung cấp các bữa ăn miễn phí cho bệnh nhân.",
                "Bệnh viện đa khoa Thị Xã Thuận An",
                "12/2009"));
        singleItem.add(new SingleItemModel("Quán cơm xã hội nụ cười 1",
                "https://i.imgur.com/tFBlufn.jpg",
                "Thùy Trâm (một thành viên của CLB thiện nguyện Nhịn Ăn Sáng) kể: Một hôm, CLB chỉ nấu 100 suất cơm. Khi các thành viên nhễ nhại mồ hôi mang cơm tới bệnh viện (BV) thì cũng đúng giờ trưa, bà con đã tụ tập rất đông. Do số người có mặt vượt quá suất cơm mà CLB chuẩn bị nên chẳng mấy chốc, cơm đã hết sạch. Lúc này, một người đàn ông trung niên lao đến, chỉ thẳng tay vào mặt Thùy Trâm, la lớn: “Tưởng có cơm phát miễn phí là ngon sao? Không thấy người ta đứng chờ cả buổi hả. Tôi nghèo tôi mới ra đây, chứ có tiền ra chen lấn làm gì để mấy người vô tâm khinh rẻ”.",
                "quận Gò Vấp, TP HCM",
                ""));
        dm.setAllItemsInSection(singleItem);
        allSampleData.add(dm);
    }

    public void addSelection4Data() {
        SectionDataModel dm = new SectionDataModel();
        ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();
        dm.setHeaderTitle("Event cần quyên góp");
        singleItem.add(new SingleItemModel("Ủng hộ đồng bảo miền trung bị lũ lụt thiên tai",
                "https://i.imgur.com/1uOaKfR.jpg",
                "Sáng 20.9, thay mặt Đảng đoàn, Đoàn Chủ tịch Tổng LĐLĐVN, Phó Chủ tịch Thường trực Tổng LĐLĐVN Trần Thanh Hải đã kêu gọi cán bộ, công chức, viên chức, đoàn viên công đoàn, CNVCLĐ, các nhà hảo tâm trong cả nước quyên góp ủng hộ đồng bào miền Trung bị thiệt hại do mưa lũ gây ra.Dự lễ phát động có các Phó Chủ tịch: Mai Đức Chính, Trần Văn Lý, Trần Văn Thuật và đại diện các đơn vị trực thuộc cơ quan Tổng LĐLĐVN.\n" +
                        "Vừa qua, bão số 10 đã tàn phá và gây ngập lụt hàng loạt tại các tỉnh miền Trung như: Hà Tĩnh, Quảng Bình, Nghệ An, Quảng Trị… Bão lũ đã làm hơn 10 người chết và mất tích; hơn 200 người bị thương; hàng trăm nghìn ngôi nhà bị sập và tốc mái; hàng chục vạn hecta lúa và hoa màu bị ngập; nhiều tuyến đường, trường học bị hư hại nặng…\n" +
                        "Tổng giá trị thiệt hại về tài sản của nhân dân và nhà nước ước tính hơn 11 nghìn tỉ đồng; bão lũ đã khiến hàng chục nghìn người lâm vào cảnh khó khăn, cần sự giúp đỡ của CB CNVCLĐ trong cả nước\n",
                "cả nước",
                ""));
        singleItem.add(new SingleItemModel("Cơm từ thiện",
                "https://i.imgur.com/U8wRLrE.jpg",
                "HIện nay chúng tôi đang tở chức hoạt động cơm từ thiện cho các bệnh nhân tại bệnh viện Bình Dương. Dự trù sẽ là 1000 suất ăn phát trong 3 ngày. Chương trình sẽ diễn ra vào ngày 25/11/2017.\n" +
                        "Hiện tại chúng tôi đã có đầy đủ trang thiết bị để chuẩn bị chế biến. Chúng tôi hiện tại thiếu kinh phí để thực hiện đủ 1000 suất cơm nên cần quy động mạnh thường quân quyên góp. Hi vọng sẽ được mọi người quan tâm và hỗ trợ để chúng tôi trao cho những bệnh nhân nghèo ở đây những bữa cơm cũng như tiếp thêm động lực để cho họ vượt qua khỏi những cơn bệnh.\n",
                "32/15A Lê Lợi, Phú Hòa, Bình Dương",
                "25/11/2017."));

        dm.setAllItemsInSection(singleItem);
        allSampleData.add(dm);
    }

    public void addSelection5Data() {
        SectionDataModel dm = new SectionDataModel();
        ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();
        dm.setHeaderTitle("Nhà tài trợ");
        singleItem.add(new SingleItemModel("Becamex IDC",
                "https://i.imgur.com/1ij88qw.jpg",
                "Tổng công ty Đầu tư và Phát triển công nghiệp - TNHH Một thành viên (Becamex IDC) được thành lập từ năm 1976, sau 40 năm xây dựng và phát triển đến nay Becamex IDC đã trở thành thương hiệu có uy tín trên lĩnh vực đầu tư và xây dựng hạ tầng Khu công nghiệp, Khu dân cư, Đô Thị và hạ tầng giao thông.\n" +
                        "Trong quá trình hình thành và phát triển, để tăng khả năng cạnh tranh, công ty đã sáp nhập, đầu tư và thành lập các công ty thành viên. Đến nay công ty đã có 22 công ty thành viên hoạt động trong các lĩnh vực: chứng khoán, tài chính, bảo hiểm, ngân hàng, xây dựng, thương mại, bất động sản, dịch vụ, viễn thông – công nghệ thông tin, sản xuất bê tông, vật liệu xây dựng, khai thác khoáng sản, dược phẩm, y tế và giáo dục.\n",
                "cả nước",
                ""));


        dm.setAllItemsInSection(singleItem);
        allSampleData.add(dm);
    }

}
