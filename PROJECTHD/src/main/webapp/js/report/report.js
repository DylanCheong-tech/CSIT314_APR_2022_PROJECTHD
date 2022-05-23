// set the dimensions and margins of the graph
const margin = { top: 10, right: 150, bottom: 30, left: 60 },
    width = 700 - margin.left - margin.right,
    height = 350 - margin.top - margin.bottom;

// append the svg object to the body of the page
const svg = d3.select("#report-graph")
    .append("svg")
    .attr("id", "svg-report")
    .attr("width", width + margin.left + margin.right)
    .attr("height", height + margin.top + margin.bottom)
    // .attr("width", "50%")
    // .attr("height", height + margin.top + margin.bottom)
    .append("g")
    .attr("transform", `translate(${margin.left},${margin.top})`);



// //Read the data
// d3.csv("./data.csv",
//     // When reading the csv, I must format variables:
//     function (d) {
//         // return { date : d3.timeParse("%Y-%m-%d")(d.date), value : d.value }
//         return { date: d.year, value: parseInt(d.population) }
//     }).then(
// Now I can use this dataset:

function draw_graph(data) {
    console.log(data)
    // Add X axis --> it is a date format
    const x = d3.scaleLinear()
        .domain(d3.extent(data, d => d.month))
        .range([0, width])
        .paddingInner(0.05);
    svg.append("g")
        .attr("transform", "translate(0," + height + ")")
        .call(d3.axisBottom(x));

    svg.append("text")
        .attr("class", "x label")
        .attr("text-anchor", "end")
        .attr("x", width)
        .attr("y", height + margin.bottom)
        .text("Month");

    // Add Y axis
    const y = d3.scaleLinear()
        .domain([0, 250])
        .range([height, 0]);
    svg.append("g")
        .call(d3.axisLeft(y));

    svg.append("text")
        .attr("class", "y label")
        .attr("text-anchor", "end")
        .attr("y", 0)
        .attr("dy", "-3em")
        .attr("transform", "rotate(-90)")
        .text("Spending (Average)");

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
    // Add the line
    svg.append("path")
        .datum(data)
        .attr("fill", "none")
        .attr("stroke", "#000000")
        .attr("stroke-width", 1.5)
        .attr("d", d3.line()
            .x(d => x(d.month))
            .y(d => y(d.value))
        )

    // svg.append("text")
    //     .attr("transform", "translate(" + (width + 3) + "," + y(data[data.length - 1].value) + ")")
    //     .attr("dy", "0em")
    //     .attr("dx", ".5em")
    //     .attr("text-anchor", "start")
    //     .style("fill", "#000000")
    //     .text("Open");
    // Add the points
    svg
        .append("g")
        .selectAll("dot")
        .data(data)
        .join("circle")
        .attr("cx", d => x(d.month))
        .attr("cy", d => y(d.value))
        .attr("r", 5)
        .attr("fill", "#000000");
}


// })

// d3.csv("./data2.csv",
//     // When reading the csv, I must format variables:
//     function (d) {
//         // return { date : d3.timeParse("%Y-%m-%d")(d.date), value : d.value }
//         return { date: d.year, value: parseInt(d.population) }
//     }).then(
//         // Now I can use this dataset:
//         function (data) {
//             console.log(data)
//             // Add X axis --> it is a date format
//             const x = d3.scaleTime()
//                 //   .domain(d3.extent(data, d => d.date))
//                 .domain(d3.extent(data, d => d.date))
//                 .range([0, width]);
//             // svg.append("g")
//             //     .attr("transform", "translate(0," + height + ")")
//             //     .call(d3.axisBottom(x));
//             // Add Y axis
//             const y = d3.scaleLinear()
//                 //   .domain( [8000, 9200])
//                 .domain([0, 100])
//                 .range([height, 0]);
//             // svg.append("g")
//             //     .call(d3.axisLeft(y));
//             // Add the line
//             svg.append("path")
//                 .datum(data)
//                 .attr("fill", "none")
//                 .attr("stroke", "#000000")
//                 .attr("stroke-width", 1.5)
//                 .attr("d", d3.line()
//                     .x(d => x(d.date))
//                     .y(d => y(d.value))
//                 )
//             // Add the points
//             svg
//                 .append("g")
//                 .selectAll("dot")
//                 .data(data)
//                 .join("circle")
//                 .attr("cx", d => x(d.date))
//                 .attr("cy", d => y(d.value))
//                 .attr("r", 5)
//                 .attr("fill", "#000000");

//             // add legends 
//             var legend_keys = ["retweets", "favorites", "tweets"]
//             var colDict = { "retweets": "black", "favorites": "#FFD100", "tweets": "red" }

//             var legend_height = 100;
//             var lineLegend = svg.selectAll(".lineLegend").data(legend_keys)
//                 .enter().append("g")
//                 .attr("class", "lineLegend")
//                 .attr("transform", function (d, i) {
//                     legend_height += 20;
//                     return "translate(" + (width + margin.right - 95) + "," + (legend_height) + ")";
//                 });

//             lineLegend.append("text").text(function (d) { return d; })
//                 .attr("transform", "translate(15, 6)"); //align texts with boxes

//             lineLegend.append("rect")
//                 .attr("fill", d => colDict[d])
//                 .attr("width", 12).attr('height', 5);
//         })

// function draw_graph(data, x_axis_label, y_axis_label, ticks) {
//     console.log(data)
//     // Add X axis
//     const groups = data.map(d => d.month)
//     console.log(groups);
//     // const x = d3.scaleBand()
//     //     .domain(groups)
//     // .domain(d3.extent(data, d => d.key))
//     //     .range([0, width])
//     //     .padding([0.2]);

//     // Add X axis
//     const x = d3.scaleBand()
//         .domain(groups)
//         .range([0, width])
//         .padding([0.2])
//     svg.append("g")
//         .attr("transform", `translate(0, ${height})`)
//         .call(d3.axisBottom(x).tickSize(0));

//     // svg.append("g")
//     //     .attr("transform", "translate(0," + height + ")")
//     //     .call(d3.axisBottom(x).ticks(ticks, 'd'));

//     // var subgroups = data.map((d) => { return d.menuitem; });
//     // hardcode here for one month subgroups
//     var data_copy = { ...data[0] };
//     delete data_copy.month;
//     subgroups = Object.keys(data_copy);
//     console.log(subgroups);
//     // console.log(subgroups.map(function (key){console.log(key)}));
//     const xSubgroup = d3.scaleBand()
//         .domain(subgroups)
//         .range([0, x.bandwidth()])
//         .padding([0.15])

//     svg.append("text")
//         .attr("class", "x label")
//         .attr("text-anchor", "end")
//         .attr("x", width)
//         .attr("y", height + margin.bottom - 5)
//         .attr("font-size", "1.5em")
//         .text(x_axis_label);


//     // var max_data_value = d3.max(data, d => Math.max(d.value));
//     console.log(Math.max(...Object.values(data_copy)))
//     // Add Y axis
//     const y = d3.scaleLinear()
//         .domain([
//             0,
//             // max_data_value + (10 - max_data_value % 10)
//             Math.max(...Object.values(data_copy)) + 5
//         ])
//         .range([height, 0]);
//     svg.append("g")
//         .call(d3.axisLeft(y));

//     svg.append("text")
//         .attr("class", "y label")
//         .attr("text-anchor", "end")
//         .attr("y", 0)
//         .attr("dy", "-1.5em")
//         .attr("font-size", "1.5em")
//         .attr("transform", "rotate(-90)")
//         .text(y_axis_label);

//     // gridlines in y axis function
//     function make_y_gridlines() {
//         return d3.axisLeft(y)
//             .ticks(5)
//     }
//     // add the Y gridlines
//     svg.append("g")
//         .attr("class", "grid")
//         .call(make_y_gridlines()
//             .tickSize(-width)
//             .tickFormat("")
//         )

//     // Append rectangles for bar chart
//     // svg.selectAll(".bar")
//     //     .data(data)
//     //     .enter().append("rect")
//     //     .attr("class", "bar")
//     //     .attr("fill", "#FFD100")
//     //     .attr("x", function (d) { return x(d.menuitem); })
//     //     .attr("width", x.bandwidth())
//     //     .attr("y", function (d) { return y(d.value); })
//     //     .attr("height", function (d) { return height - y(d.value); });

//     const color = d3.scaleOrdinal()
//         .domain(subgroups)
//         .range(['#e41a1c', '#377eb8', '#4daf4a', '#FFD100'])

//     // Show the bars
//     svg.append("g")
//         .selectAll("g")
//         // Enter in data = loop group per group
//         .data(data)
//         .join("g")
//         .attr("transform", d => `translate(${x(d.month)}, 0)`)
//         .selectAll("rect")
//         .data(function (d) { return subgroups.map(function (key) { console.log(d[key]); return { key: key, value: d[key] }; }); })
//         .join("rect")
//         .attr("x", d => xSubgroup(d.key))
//         .attr("y", d => y(d.value))
//         .attr("width", xSubgroup.bandwidth())
//         .attr("height", d => height - y(d.value))
//         .attr("fill", d => color(d.key));

// }

d3.select("#report-graph").append("button").text("Download").attr("type", "button");

function download() {
    // var svg = document.getElementById("svg-report").innerHTML;
    // console.log(svg)
    // var blob =  new Blob([svg.toString()]);
    // console.log(blob)
    // console.log(window.URL.createObjectURL(blob));

    var svg = document.getElementById("svg-report");
    let { width, height } = svg.getBBox();

    let cloneSVG = svg.cloneNode(true);

    let outerHTML = cloneSVG.outerHTML;
    blob = new Blob([outerHTML], { type: 'image/svg+xml;charset=utf-8' });

    let URL = window.URL || window.webkitURL || window;

    let blobURL = URL.createObjectURL(blob);
    console.log(blobURL)

    let image = new Image();

    image.onload = () => {
        let canvas = document.createElement('canvas');

        canvas.widht = width;

        canvas.height = height;
        let context = canvas.getContext('2d');
        // draw image in canvas starting left-0 , top - 0  
        context.drawImage(image, 0, 0, width, height);
        //  downloadImage(canvas); need to implement

        let png = canvas.toDataURL();
        console.log(png);
        URL.revokeObjectURL();

    }

    image.src = blobURL;
    console.log("here")
    console.log(image)


}

setTimeout(() => {
    download();
}, 2000);

$.ajax({
    async: true,
    "url": "/getMonthlySpendReport",
    "type": "get",
    "dataType": "json",
    "complete": (data) => {
        console.log(data.responseJSON);
        draw_graph(data.responseJSON);
    }
});