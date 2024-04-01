from kivy.app import App
from kivy.uix.button import Button
from kivy.uix.camera import Camera
from kivy.uix.boxlayout import BoxLayout

from pyzbar.pyzbar import decode
from PIL import Image

class CameraApp(App):

    def build(self):
        layout = BoxLayout(orientation='vertical')

        self.camera = Camera(play=True)
        layout.add_widget(self.camera)

        button = Button(text='Scan Barcode')
        button.bind(on_press=self.scan_barcode)
        layout.add_widget(button)

        return layout

    def scan_barcode(self, instance):
        image_texture = self.camera.export_as_image()
        image_texture.save('barcode.png')  # Сохраняем изображение с камеры

        decoded_objects = decode(Image.open('barcode.png'))  # Декодируем штрих-код

        if decoded_objects:
            barcode_data = decoded_objects[0].data.decode('utf-8')  # Получаем данные из штрих-кода
            print("Scanned Barcode:", barcode_data)

            code = ['123456', '789012', '345678']  # Пример массива с кодами

            if barcode_data in code:
                print("Barcode found in the code list!")
            else:
                print("Barcode not found in the code list.")
        else:
            print("No barcode detected.")

if __name__ == '__main__':
    CameraApp().run()
