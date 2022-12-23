package fastcampus.part3.face_recognition.recognition

import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import androidx.camera.view.PreviewView
import androidx.lifecycle.Lifecycle
import com.google.mlkit.vision.face.FaceDetection
import com.google.mlkit.vision.face.FaceDetectorOptions

internal class FaceAnalyzer(
    lifecycle: Lifecycle,
    private val preview: PreviewView,
)  : ImageAnalysis.Analyzer{
    private var widthScaleFactor = 1.0f
    private var heightScaleFactor = 1.0f

    private val options = FaceDetectorOptions.Builder()
        .setPerformanceMode(FaceDetectorOptions.PERFORMANCE_MODE_ACCURATE) //성능
        .setContourMode(FaceDetectorOptions.CONTOUR_MODE_ALL) //윤곽선
        .setClassificationMode(FaceDetectorOptions.CLASSIFICATION_MODE_ALL) //표정
        .setMinFaceSize(0.4f)
        .build()

    private val detector = FaceDetection.getClient(options)

    private var detectStatus = FaceAnalyzerStatus.UnDetect


    override fun analyze(image: ImageProxy) {
        widthScaleFactor = preview.width.toFloat() / image.height
        heightScaleFactor = preview.height.toFloat() / image.width

    }
}