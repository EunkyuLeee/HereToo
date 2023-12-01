import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class SearchPanel extends JPanel {

    private Integer page;
    private JPanel[] res;
    private JLabel pageNum;
    private Integer total;
    private JLabel resultNum;
    private final MainFrame mainFrame;
    private static final String indexAlphabet = "ABCDE";

    public SearchPanel(MainFrame mf) {
        mainFrame = mf;

        page = 1;

        setPreferredSize(new Dimension(300, 100)); // 검색창이 들어갈 왼쪽 패널 크기
        setLayout(new BorderLayout());

        JTextField searchField = new JTextField(); // 검색창 생성
        searchField.setText("여기에 검색어를 입력하세요");

        // 포커스 이벤트를 통해 힌트 텍스트 관리
        searchField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (searchField.getText().equals("여기에 검색어를 입력하세요")) {
                    searchField.setText("");
                    searchField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (searchField.getText().isEmpty()) {
                    searchField.setForeground(Color.GRAY);
                    searchField.setText("여기에 검색어를 입력하세요");
                }
            }
        });


        // 검색창 부분 추가
        JPanel searchButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // 검색 버튼을 오른쪽에 배치

        add(searchField, BorderLayout.CENTER);
        add(searchButtonPanel, BorderLayout.EAST);

        // 여기서부터는 검색 결과를 보여주는 로직을 구현하세요.
    }

    private void search(String keyWord) {
        // 여기서 검색 로직을 구현하세요.
    }
}
