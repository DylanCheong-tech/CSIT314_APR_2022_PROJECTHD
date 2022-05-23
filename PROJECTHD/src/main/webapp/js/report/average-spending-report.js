// set the dimensions and margins of the graph
const margin = { top: 10, right: 150, bottom: 40, left: 60 },
    width = 800 - margin.left - margin.right,
    height = 400 - margin.top - margin.bottom;

// append the svg object to the body of the page
const svg = d3.select("#report-graph")
    .append("svg")
    .attr("id", "svg-report")
    .attr("width", width + margin.left + margin.right)
    .attr("height", height + margin.top + margin.bottom)
    .append("g")
    .attr("transform", `translate(${margin.left},${margin.top})`);

function draw_graph(data, x_axis_label, y_axis_label) {

    if (data.length == 0) {
        d3.select("#report-frame").append("div")
            .attr("id", "no-result")
            .append("img")
            .attr("src", "/img/frown-face.png");
        d3.select("#no-result")
            .append("div")
            .html("Sorry, no results found.<br />Please select another time frame");

        d3.select("#report-graph").style("display", "none");

        return;
    }

    d3.select("#report-graph").style("display", "block");
    d3.select("#no-result").remove();

    // Add X axis
    const x = d3.scaleBand()
        .domain(data.map((d) => { return d.key }))
        .range([0, width])
        .padding([0.5])
    svg.append("g")
        .attr("transform", `translate(0, ${height})`)
        .call(d3.axisBottom(x).tickSize(0));

    svg.append("text")
        .attr("class", "x label")
        .attr("text-anchor", "end")
        .attr("x", width)
        .attr("y", height + margin.bottom - 5)
        .attr("font-size", "1.5em")
        .text(x_axis_label);

    var max_data_value = d3.max(data, d => Math.max(d.value));
    // Add Y axis
    const y = d3.scaleLinear()
        .domain([
            0,
            max_data_value + (50 - max_data_value % 50) + 50
        ])
        .range([height, 0]);
    svg.append("g")
        .call(d3.axisLeft(y));

    svg.append("text")
        .attr("class", "y label")
        .attr("text-anchor", "end")
        .attr("y", 0)
        .attr("dy", "-1.5em")
        .attr("font-size", "1.5em")
        .attr("transform", "rotate(-90)")
        .text(y_axis_label);

    // gridlines in y axis function
    function make_y_gridlines() {
        return d3.axisLeft(y)
            .ticks(5)
    }
    // add the Y gridlines
    svg.append("g")
        .attr("class", "grid")
        .call(make_y_gridlines()
            .tickSize(-width)
            .tickFormat("")
        )

    // Append rectangles for bar chart
    svg.selectAll(".bar")
        .data(data)
        .enter().append("rect")
        .attr("class", "bar")
        .attr("fill", "#FFD100")
        .attr("x", function (d) { return x(d.key); })
        .attr("width", x.bandwidth())
        .attr("y", function (d) { return y(d.value); })
        .attr("height", function (d) { return height - y(d.value); });

}

d3.select("#report-graph").append("button").text("Download").attr("type", "button");

var report_period = "hourly";

document.getElementById("report-period").onchange = function () {
    report_period = this.value;
    var report_period_ele = document.getElementById("report-time");

    if (report_period == "hourly") {
        report_period_ele.type = "date";
    }
    else if (report_period == "daily") {
        report_period_ele.type = "week";
    }
    else if (report_period == "weekly") {
        report_period_ele.type = "month";
    }
    else {
        report_period_ele.type = "number";
        report_period_ele.placeholder = "yyyy";
        report_period_ele.min = "1900";
        report_period_ele.max = "2099";
    }
}

function clean_graph() {
    svg.selectAll("*").remove();
}

function generateReport() {
    console.log(document.getElementById("report-time").value);
    var report_time = document.getElementById("report-time").value;
    var url_string = "";
    var x_axis_label = "";

    if (report_period == "hourly") {
        var split_string = report_time.split("-");
        url_string = "/getHourlyAverageSpendingReport" + `?year=${split_string[0]}&month=${split_string[1]}&day=${split_string[2]}`;
        x_axis_label = `Hour`;
    }
    else if (report_period == "daily") {
        var split_string = report_time.split("-");
        url_string = "/getDailyAverageSpendingReport" + `?year=${split_string[0]}&week=${split_string[1].substr(1)}`;
        x_axis_label = `Day`;
    }
    else if (report_period == "weekly") {
        var split_string = report_time.split("-");
        url_string = "/getWeeklyAverageSpendingReport" + `?year=${split_string[0]}&month=${split_string[1]}`;
        x_axis_label = `Week`;
    }
    else {
        url_string = "/getMonthlyAverageSpendingReport" + `?year=${report_time}`;
        x_axis_label = `Month`;
    }

    $.ajax({
        async: true,
        "url": url_string,
        "type": "get",
        "dataType": "json",
        "complete": (data) => {
            clean_graph();
            draw_graph(data.responseJSON, x_axis_label, "Average Spending ($)");
        }
    });
}