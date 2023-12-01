import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Destination {
    String name;
    String description;
    ImageIcon[] images; // 이미지 배열 대신 ImageIcon 배열을 사용
    String season;
    String location;
    String theme;

    public Destination(String name, String description, ImageIcon[] images, String season, String location, String theme) {
        this.name = name;
        this.description = description;
        this.images = images; // ImageIcon 배열 초기화
        this.season = season;
        this.location = location;
        this.theme = theme;
    }
}

class DestinationPanel extends JPanel {
    public DestinationPanel(Destination destination) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel nameLabel = new JLabel(destination.name);
        nameLabel.setFont(new Font("Serif", Font.BOLD, 20));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextArea descriptionArea = new JTextArea(destination.description);
        descriptionArea.setEditable(false);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);

        // 아래는 이미지가 실제로 존재하지 않기 때문에, 임시 레이블을 생성합니다.
        // 실제 이미지를 사용하려면, ImageIcon 객체를 생성하고 해당 객체를 JLabel에 추가하세요.
        JLabel imageLabel = new JLabel("이미지 없음");
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(new JButton("숙박"));
        buttonPanel.add(new JButton("맛집"));
        buttonPanel.add(new JButton("투어 상품"));

        add(nameLabel);
        add(imageLabel);
        add(descriptionArea);
        add(buttonPanel);
    }
}

class RecommendationPanel extends JPanel {
    private List<Destination> allDestinations;
    private JPanel destinationsPanel;
    private JComboBox<String> seasonCombo;
    private JComboBox<String> locationCombo;
    private JComboBox<String> themeCombo;

    public RecommendationPanel() {
        setLayout(new BorderLayout());
        initializeDestinations();

        // 시즌, 지역, 테마 콤보 박스에 "전체" 옵션을 추가합니다.
        String[] seasons = {"전체", "봄", "여름", "가을", "겨울"};
        String[] locations = {"전체", "부산", "대구", "경상도", "전라도", "경기도", "강원도", "서울", "제주도"};
        String[] themes = {"전체", "문화", "자연", "역사", "레저", "쇼핑"}; // 테마 데이터 배열 추가

        seasonCombo = new JComboBox<>(seasons);
        locationCombo = new JComboBox<>(locations);
        themeCombo = new JComboBox<>(themes);

        JPanel comboPanel = new JPanel();
        comboPanel.add(new JLabel("시즌:"));
        comboPanel.add(seasonCombo);
        comboPanel.add(new JLabel("지역:"));
        comboPanel.add(locationCombo);
        comboPanel.add(new JLabel("테마:"));
        comboPanel.add(themeCombo);

        add(comboPanel, BorderLayout.NORTH);

        destinationsPanel = new JPanel();
        destinationsPanel.setLayout(new GridLayout(0, 2));
        addDestinationsToPanel("전체", "전체", "전체"); // 초기 목적지 패널 업데이트

        JScrollPane scrollPane = new JScrollPane(destinationsPanel);
        scrollPane.setPreferredSize(new Dimension(400, 300));

        add(scrollPane, BorderLayout.CENTER);

        // 콤보 박스의 액션 리스너
        seasonCombo.addActionListener(e -> updateDestinationsPanel());
        locationCombo.addActionListener(e -> updateDestinationsPanel());
        themeCombo.addActionListener(e -> updateDestinationsPanel());
    }

    private void initializeDestinations() {
        allDestinations = new ArrayList<>();
        allDestinations.add(new Destination("남산타워", "서울의 명소입니다.", null, "봄", "서울", "문화"));
        allDestinations.add(new Destination("해운대 해변", "부산의 해변입니다.", null, "여름", "부산", "자연"));
        allDestinations.add(new Destination("경복궁", "서울의 대표적인 궁궐입니다.", null, "봄", "서울", "역사"));
    }

    private void addDestinationsToPanel(String selectedSeason, String selectedLocation, String selectedTheme) {
        destinationsPanel.removeAll();
        List<Destination> filteredDestinations = allDestinations.stream()
                .filter(d -> selectedSeason.equals("전체") || d.season.equals(selectedSeason))
                .filter(d -> selectedLocation.equals("전체") || d.location.equals(selectedLocation))
                .filter(d -> selectedTheme.equals("전체") || d.theme.equals(selectedTheme))
                .collect(Collectors.toList());

        for (Destination destination : filteredDestinations) {
            destinationsPanel.add(new DestinationPanel(destination));
        }

        destinationsPanel.revalidate();
        destinationsPanel.repaint();
    }

    private void updateDestinationsPanel() {
        String selectedSeason = (String) seasonCombo.getSelectedItem();
        String selectedLocation = (String) locationCombo.getSelectedItem();
        String selectedTheme = (String) themeCombo.getSelectedItem();
        addDestinationsToPanel(selectedSeason, selectedLocation, selectedTheme);
    }
}