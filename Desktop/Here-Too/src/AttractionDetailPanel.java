import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AttractionDetailPanel extends JPanel {
    public AttractionDetailPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE);
        setBorder(new EmptyBorder(10, 10, 10, 10));

        // 상단 타이틀 영역
        JLabel titleLabel = new JLabel("이산손 정원", JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 20));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setBorder(new EmptyBorder(10, 0, 10, 0));
        add(titleLabel);

        // 중앙 이미지 영역
        ImageIcon image = new ImageIcon("your-image-path.jpg"); // 이미지 경로를 실제 경로로 변경하세요.
        JLabel imageLabel = new JLabel(image);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(imageLabel);

        // 설명 텍스트 영역
        JTextArea descriptionArea = new JTextArea(5, 20);
        descriptionArea.setText("동양 최대규모의 정원..."); // 여기에 실제 텍스트를 채워 넣으세요.
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setLineWrap(true);
        descriptionArea.setEditable(false);
        descriptionArea.setBackground(Color.LIGHT_GRAY);
        descriptionArea.setBorder(new EmptyBorder(10, 10, 10, 10));
        add(descriptionArea);

        // 별점 영역
        JPanel starPanel = new JPanel();
        starPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        starPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        starPanel.add(new JLabel(new ImageIcon("your-star-icon-path.png"))); // 별 아이콘 경로를 실제 경로로 변경하세요.
        starPanel.add(new JLabel("5,093 review"));
        add(starPanel);

        // 상세 정보 영역
        addInfoLine("위치", "경상남도 통영시 산양읍 산양일주로 205");
        addInfoLine("연락처", "055-642-4737");
        addInfoLine("영업시간", "24시간");
        addInfoLine("소개", "공원 전체에 자리잡고 있는 이산손 정원은..."); // 여기에 실제 텍스트를 채워 넣으세요.
    }

    // 정보 라인을 추가하는 헬퍼 메소드
    private void addInfoLine(String fieldName, String info) {
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        infoPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        infoPanel.add(new JLabel(fieldName + ": "));
        infoPanel.add(new JLabel(info));
        add(infoPanel);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("관광지 상세 정보");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new AttractionDetailPanel());
        frame.pack();
        frame.setVisible(true);
    }
}
