package Audio;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class AudioFileLoader {
    // 파일 선택 다이얼로그를 띄우고 wav 파일만 고를 수 있도록 필터링
    public File chooseWavFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("WAV 파일 선택");
        
        // wav 파일 필터 설정
        fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            public boolean accept(File f) {
                return f.isDirectory() || f.getName().toLowerCase().endsWith(".wav");
            }

            public String getDescription() {
                return "WAV 오디오 파일 (*.wav)";
            }
        });

        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            // .wav 확장자 확인
            if (selectedFile.getName().toLowerCase().endsWith(".wav")) {
                return selectedFile;
            } else {
                JOptionPane.showMessageDialog(null, "유효한 WAV 파일이 아닙니다.");
            }
        }
        return null;
    }
}
