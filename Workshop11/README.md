## Map - ForEach Farkı
JavaScript'te `map` ve `forEach` metotları, diziler üzerinde iterasyon yapmanıza olanak tanır ancak farklı amaçlar ve kullanımlar için tasarlanmışlardır.

### `forEach`
- **Amacı:** Bir dizi üzerinde yan etkileri (side-effects) olan işlemler gerçekleştirmek.
- **Geri Dönüş Değeri:** `undefined` döner. Yani, dizinin elemanlarını dönüştürmek veya yeni bir dizi oluşturmak için kullanılmaz.
- **Kullanımı:** Dizi elemanları üzerinde döngü kurar ve her bir eleman için verilen callback fonksiyonunu çalıştırır.

Örnek:
```javascript
const numbers = [1, 2, 3, 4];
numbers.forEach((number, index) => {
    console.log(`Index: ${index}, Value: ${number}`);
});
```
Bu örnekte, `forEach` dizinin her bir elemanını konsola yazdırmak için kullanılır.

### `map`
- **Amacı:** Bir dizi üzerinde dönüşüm yapmak ve yeni bir dizi oluşturmak.
- **Geri Dönüş Değeri:** Yeni bir dizi döner. Bu dizi, orijinal dizinin her bir elemanının callback fonksiyonu ile işlenmiş halini içerir.
- **Kullanımı:** Dizi elemanlarını belirli bir işleve tabi tutar ve bu işleve göre yeni bir dizi oluşturur.

Örnek:
```javascript
const numbers = [1, 2, 3, 4];
const squaredNumbers = numbers.map((number) => number * number);
console.log(squaredNumbers); // [1, 4, 9, 16]
```
Bu örnekte, `map` dizinin her bir elemanını karesini alarak yeni bir dizi oluşturur.

### Özet
- `forEach`: Yan etkileri olan işlemler için kullanılır, geri dönüş değeri `undefined`'dır.
- `map`: Dizi elemanlarını dönüştürüp yeni bir dizi oluşturur.

Her iki yöntem de dizi üzerinde iterasyon yaparken kullanılır, ancak kullanım amaçları ve geri dönüş değerleri farklıdır. `forEach`, diziyi değiştirmek yerine işlem yapmak için kullanılırken, `map` diziyi değiştirip yeni bir dizi oluşturur.

## Callback Function
JavaScript'te callback fonksiyonları, bir işlemin tamamlanmasından sonra başka bir işlemi gerçekleştirmek için kullanılan fonksiyonlardır. Genellikle asenkron işlemlerle birlikte kullanılırlar, ancak senkron işlemler için de kullanılabilirler. Callback fonksiyonları, diğer fonksiyonlara argüman olarak geçirilir ve bu fonksiyonlar tamamlandığında çağrılır.

### Temel Kullanım

Bir callback fonksiyonunun nasıl çalıştığını anlamak için basit bir örnekle başlayalım:

```javascript
function greet(name, callback) {
    console.log('Merhaba ' + name);
    callback();
}

function afterGreeting() {
    console.log('Bu, selamlamadan sonra çalışacak.');
}

greet('Kanks', afterGreeting);
```

Bu örnekte, `greet` fonksiyonu bir `name` ve bir `callback` fonksiyonu alır. `greet` fonksiyonu önce adı yazdırır, ardından callback fonksiyonunu çağırır. Çıktı şu şekilde olacaktır:
```
Merhaba Kanks
Bu, selamlamadan sonra çalışacak.
```

### Asenkron Callback Kullanımı

Callback fonksiyonları özellikle asenkron işlemlerle kullanıldığında çok faydalıdır. Örneğin, bir API çağrısı yaptıktan sonra sonucu işlemek için bir callback fonksiyonu kullanabiliriz.

```javascript
function fetchData(callback) {
    setTimeout(() => {
        console.log('Veri çekildi.');
        callback('Veri');  // Veriyi callback fonksiyonuna iletmek
    }, 2000);
}

function processData(data) {
    console.log('İşlenen veri: ' + data);
}

fetchData(processData);
```

Bu örnekte, `fetchData` fonksiyonu bir veriyi çektiğini simüle eder ve 2 saniye sonra callback fonksiyonunu çağırır. `processData` fonksiyonu ise çekilen veriyi işler. Çıktı şu şekilde olacaktır:
```
Veri çekildi.
İşlenen veri: Veri
```

### Anonymous Callback Fonksiyonları

Callback fonksiyonları anonim (isimsiz) olarak da tanımlanabilir. Örneğin:

```javascript
function greet(name, callback) {
    console.log('Merhaba ' + name);
    callback();
}

greet('Kanks', function() {
    console.log('Bu, selamlamadan sonra çalışacak.');
});
```

### Callback Hell

Çok fazla asenkron işlemin iç içe olması durumunda "callback hell" denilen durum ortaya çıkabilir. Bu, kodun okunabilirliğini ve bakımını zorlaştırır. Örneğin:

```javascript
doSomething(function(result1) {
    doSomethingElse(result1, function(result2) {
        doAnotherThing(result2, function(result3) {
            doFinalThing(result3, function(result4) {
                console.log('Tüm işlemler tamamlandı.');
            });
        });
    });
});
```

Bu tür durumlardan kaçınmak için `Promises` veya `async/await` gibi modern JavaScript özellikleri kullanılır.

### Özet

- **Callback Fonksiyonu:** Bir işlemin tamamlanmasından sonra çağrılan fonksiyondur.
- **Senkron Kullanım:** Bir işlemin tamamlanmasını takip eden diğer işlemler için kullanılır.
- **Asenkron Kullanım:** Asenkron işlemler (örneğin, API çağrıları) tamamlandığında sonucu işlemek için kullanılır.
- **Anonymous Callback:** Callback fonksiyonları anonim olarak tanımlanabilir.
- **Callback Hell:** İç içe geçmiş çok sayıda callback, kodun okunabilirliğini zorlaştırır; bunun yerine `Promises` veya `async/await` kullanılabilir.

Callback fonksiyonları, JavaScript'te esnek ve güçlü bir yapıdır ve asenkron programlamanın temelini oluşturur.