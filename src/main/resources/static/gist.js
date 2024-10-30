document.addEventListener("DOMContentLoaded", function () {
    google.charts.load('current', {'packages':['corechart']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {
        // Используем данные, которые переданы через Thymeleaf
        const perfData = ThData;

        // Создаем объект для хранения количества данных по каждой дате отправки
        const dataCountByDate = {};

        // Пробегаем по данным и группируем их по дате отправки
        perfData.forEach(function(perf) {
            const count_date = new Date(perf.date).toLocaleDateString();  // Преобразуем дату в формат строки

            // Если дата уже существует в объекте, увеличиваем количество грузов, иначе создаем новый ключ
            if (dataCountByDate[count_date]) {
                dataCountByDate[count_date]++;
            } else {
                dataCountByDate[count_date] = 1;
            }
        });

        // Преобразуем объект в массив для диаграммы
        const dataArray = [['Дата', 'Количество билетов']];
        for (const [date, count] of Object.entries(dataCountByDate)) {
            dataArray.push([date, count]);
        }

        // Преобразуем массив данных в формат DataTable для Google Charts
        const data = google.visualization.arrayToDataTable(dataArray);

        // Настройки диаграммы
        const options = {
            title: 'Количество билетов по дате',
            hAxis: {title: 'Дата'},
            vAxis: {title: 'Количество'},
            legend: {position: 'none'},
            bar: {groupWidth: "95%"},
            colors: ['#76A7FA'],
        };

        // Создаем и рисуем диаграмму
        const chart = new google.visualization.ColumnChart(document.getElementById('curve_chart'));
        chart.draw(data, options);
    }
});