/*
 Highcharts JS v8.0.4 (2020-03-10)

 Exporting module

 (c) 2010-2019 Torstein Honsi

 License: www.highcharts.com/license
*/
(function(c) {
    "object" === typeof module && module.exports ? (c["default"] = c, module.exports = c) : "function" === typeof define && define.amd ? define("highcharts/modules/export-data", ["highcharts", "highcharts/modules/exporting"], function(k) {
        c(k);
        c.Highcharts = k;
        return c
    }) : c("undefined" !== typeof Highcharts ? Highcharts : void 0)
})(function(c) {
    function k(b, a, c, u) {
        b.hasOwnProperty(a) || (b[a] = u.apply(null, c))
    }
    c = c ? c._modules : {};
    k(c, "mixins/ajax.js", [c["parts/Globals.js"], c["parts/Utilities.js"]], function(b, a) {
        var c = a.merge,
            u = a.objectEach;
        b.ajax = function(b) {
            var a = c(!0, {
                url: !1,
                type: "get",
                dataType: "json",
                success: !1,
                error: !1,
                data: !1,
                headers: {}
            }, b);
            b = {
                json: "application/json",
                xml: "application/xml",
                text: "text/plain",
                octet: "application/octet-stream"
            };
            var d = new XMLHttpRequest;
            if (!a.url) return !1;
            d.open(a.type.toUpperCase(), a.url, !0);
            a.headers["Content-Type"] || d.setRequestHeader("Content-Type", b[a.dataType] || b.text);
            u(a.headers, function(a, b) {
                d.setRequestHeader(b, a)
            });
            d.onreadystatechange = function() {
                if (4 === d.readyState) {
                    if (200 ===
                        d.status) {
                        var b = d.responseText;
                        if ("json" === a.dataType) try {
                            b = JSON.parse(b)
                        } catch (e) {
                            a.error && a.error(d, e);
                            return
                        }
                        return a.success && a.success(b)
                    }
                    a.error && a.error(d, d.responseText)
                }
            };
            try {
                a.data = JSON.stringify(a.data)
            } catch (A) {}
            d.send(a.data || !0)
        };
        b.getJSON = function(a, c) {
            b.ajax({
                url: a,
                success: c,
                dataType: "json",
                headers: {
                    "Content-Type": "text/plain"
                }
            })
        }
    });
    k(c, "mixins/download-url.js", [c["parts/Globals.js"]], function(b) {
        var a = b.win,
            c = a.navigator,
            u = a.document,
            k = a.URL || a.webkitURL || a,
            v = /Edge\/\d+/.test(c.userAgent);
        b.dataURLtoBlob = function(b) {
            if ((b = b.match(/data:([^;]*)(;base64)?,([0-9A-Za-z+/]+)/)) && 3 < b.length && a.atob && a.ArrayBuffer && a.Uint8Array && a.Blob && k.createObjectURL) {
                var d = a.atob(b[3]),
                    c = new a.ArrayBuffer(d.length);
                c = new a.Uint8Array(c);
                for (var f = 0; f < c.length; ++f) c[f] = d.charCodeAt(f);
                b = new a.Blob([c], {
                    type: b[1]
                });
                return k.createObjectURL(b)
            }
        };
        b.downloadURL = function(d, k) {
            var e = u.createElement("a");
            if ("string" === typeof d || d instanceof String || !c.msSaveOrOpenBlob) {
                if (v || 2E6 < d.length)
                    if (d = b.dataURLtoBlob(d), !d) throw Error("Failed to convert to blob");
                if ("undefined" !== typeof e.download) e.href = d, e.download = k, u.body.appendChild(e), e.click(), u.body.removeChild(e);
                else try {
                    var f = a.open(d, "chart");
                    if ("undefined" === typeof f || null === f) throw Error("Failed to open window");
                } catch (z) {
                    a.location.href = d
                }
            } else c.msSaveOrOpenBlob(d, k)
        }
    });
    k(c, "modules/export-data.src.js", [c["parts/Globals.js"], c["parts/Utilities.js"]], function(b, a) {
        function c(a, b) {
            var c = d.navigator,
                m = -1 < c.userAgent.indexOf("WebKit") && 0 > c.userAgent.indexOf("Chrome"),
                e = d.URL || d.webkitURL || d;
            try {
                if (c.msSaveOrOpenBlob && d.MSBlobBuilder) {
                    var p = new d.MSBlobBuilder;
                    p.append(a);
                    return p.getBlob("image/svg+xml")
                }
                if (!m) return e.createObjectURL(new d.Blob(["\ufeff" + a], {
                    type: b
                }))
            } catch (G) {}
        }
        var k = a.defined,
            F = a.extend,
            v = a.pick,
            d = b.win,
            A = d.document,
            e = b.seriesTypes,
            f = b.downloadURL,
            z = b.fireEvent;
        b.setOptions({
            exporting: {
                csv: {
                    columnHeaderFormatter: null,
                    dateFormat: "%Y-%m-%d %H:%M:%S",
                    decimalPoint: null,
                    itemDelimiter: null,
                    lineDelimiter: "\n"
                },
                showTable: !1,
                useMultiLevelHeaders: !0,
                useRowspanHeaders: !0
            },
            lang: {
                downloadCSV: "Download CSV",
                downloadXLS: "Download XLS",
                viewData: "View data table"
            }
        });
        b.addEvent(b.Chart, "render", function() {
            this.options && this.options.exporting && this.options.exporting.showTable && !this.options.chart.forExport && this.viewData()
        });
        b.Chart.prototype.setUpKeyToAxis = function() {
            e.arearange && (e.arearange.prototype.keyToAxis = {
                low: "y",
                high: "y"
            });
            e.gantt && (e.gantt.prototype.keyToAxis = {
                start: "x",
                end: "x"
            })
        };
        b.Chart.prototype.getDataRows = function(a) {
            var c = this.hasParallelCoordinates,
                d = this.time,
                e = this.options.exporting && this.options.exporting.csv || {},
                m = this.xAxis,
                p = {},
                f = [],
                B = [],
                w = [],
                r, C = function(h, c, d) {
                    if (e.columnHeaderFormatter) {
                        var g = e.columnHeaderFormatter(h, c, d);
                        if (!1 !== g) return g
                    }
                    return h ? h instanceof b.Axis ? h.options.title && h.options.title.text || (h.isDatetimeAxis ? "DateTime" : "Category") : a ? {
                        columnTitle: 1 < d ? c : h.name,
                        topLevelColumnTitle: h.name
                    } : h.name + (1 < d ? " (" + c + ")" : "") : "Category"
                },
                D = function(a, c, d) {
                    var h = {},
                        g = {};
                    c.forEach(function(c) {
                        var e = (a.keyToAxis && a.keyToAxis[c] || c) +
                            "Axis";
                        e = b.isNumber(d) ? a.chart[e][d] : a[e];
                        h[c] = e && e.categories || [];
                        g[c] = e && e.isDatetimeAxis
                    });
                    return {
                        categoryMap: h,
                        dateTimeValueAxisMap: g
                    }
                },
                g = [];
            var y = 0;
            this.setUpKeyToAxis();
            this.series.forEach(function(h) {
                var t = h.options.keys || h.pointArrayMap || ["y"],
                    q = t.length,
                    l = !h.requireSorting && {},
                    k = m.indexOf(h.xAxis),
                    f = D(h, t),
                    n;
                if (!1 !== h.options.includeInDataExport && !h.options.isInternal && !1 !== h.visible) {
                    b.find(g, function(a) {
                        return a[0] === k
                    }) || g.push([k, y]);
                    for (n = 0; n < q;) r = C(h, t[n], t.length), w.push(r.columnTitle ||
                        r), a && B.push(r.topLevelColumnTitle || r), n++;
                    var x = {
                        chart: h.chart,
                        autoIncrement: h.autoIncrement,
                        options: h.options,
                        pointArrayMap: h.pointArrayMap
                    };
                    h.options.data.forEach(function(a, b) {
                        c && (f = D(h, t, b));
                        var g = {
                            series: x
                        };
                        h.pointClass.prototype.applyOptions.apply(g, [a]);
                        a = g.x;
                        var m = h.data[b] && h.data[b].name;
                        n = 0;
                        h.xAxis && "name" !== h.exportKey || (a = m);
                        l && (l[a] && (a += "|" + b), l[a] = !0);
                        p[a] || (p[a] = [], p[a].xValues = []);
                        p[a].x = g.x;
                        p[a].name = m;
                        for (p[a].xValues[k] = g.x; n < q;) b = t[n], m = g[b], p[a][y + n] = v(f.categoryMap[b][m],
                            f.dateTimeValueAxisMap[b] ? d.dateFormat(e.dateFormat, m) : null, m), n++
                    });
                    y += n
                }
            });
            for (q in p) Object.hasOwnProperty.call(p, q) && f.push(p[q]);
            var q = a ? [B, w] : [w];
            for (y = g.length; y--;) {
                var t = g[y][0];
                var l = g[y][1];
                var x = m[t];
                f.sort(function(a, b) {
                    return a.xValues[t] - b.xValues[t]
                });
                var E = C(x);
                q[0].splice(l, 0, E);
                a && q[1] && q[1].splice(l, 0, E);
                f.forEach(function(a) {
                    var b = a.name;
                    x && !k(b) && (x.isDatetimeAxis ? (a.x instanceof Date && (a.x = a.x.getTime()), b = d.dateFormat(e.dateFormat, a.x)) : b = x.categories ? v(x.names[a.x], x.categories[a.x],
                        a.x) : a.x);
                    a.splice(l, 0, b)
                })
            }
            q = q.concat(f);
            z(this, "exportData", {
                dataRows: q
            });
            return q
        };
        b.Chart.prototype.getCSV = function(a) {
            var b = "",
                c = this.getDataRows(),
                d = this.options.exporting.csv,
                e = v(d.decimalPoint, "," !== d.itemDelimiter && a ? (1.1).toLocaleString()[1] : "."),
                m = v(d.itemDelimiter, "," === e ? ";" : ","),
                k = d.lineDelimiter;
            c.forEach(function(a, d) {
                for (var f, n = a.length; n--;) f = a[n], "string" === typeof f && (f = '"' + f + '"'), "number" === typeof f && "." !== e && (f = f.toString().replace(".", e)), a[n] = f;
                b += a.join(m);
                d < c.length - 1 && (b +=
                    k)
            });
            return b
        };
        b.Chart.prototype.getTable = function(a) {
            var b = '<table id="highcharts-data-table-' + this.index + '">',
                c = this.options,
                d = a ? (1.1).toLocaleString()[1] : ".",
                e = v(c.exporting.useMultiLevelHeaders, !0);
            a = this.getDataRows(e);
            var f = 0,
                k = e ? a.shift() : null,
                m = a.shift(),
                w = function(a, b, c, e) {
                    var g = v(e, "");
                    b = "text" + (b ? " " + b : "");
                    "number" === typeof g ? (g = g.toString(), "," === d && (g = g.replace(".", d)), b = "number") : e || (b = "empty");
                    return "<" + a + (c ? " " + c : "") + ' class="' + b + '">' + g + "</" + a + ">"
                };
            !1 !== c.exporting.tableCaption && (b +=
                '<caption class="highcharts-table-caption">' + v(c.exporting.tableCaption, c.title.text ? c.title.text.replace(/&/g, "&amp;").replace(/</g, "&lt;").replace(/>/g, "&gt;").replace(/"/g, "&quot;").replace(/'/g, "&#x27;").replace(/\//g, "&#x2F;") : "Chart") + "</caption>");
            for (var r = 0, u = a.length; r < u; ++r) a[r].length > f && (f = a[r].length);
            b += function(a, b, d) {
                var f = "<thead>",
                    g = 0;
                d = d || b && b.length;
                var l, k = 0;
                if (l = e && a && b) {
                    a: if (l = a.length, b.length === l) {
                        for (; l--;)
                            if (a[l] !== b[l]) {
                                l = !1;
                                break a
                            }
                        l = !0
                    } else l = !1;l = !l
                }
                if (l) {
                    for (f += "<tr>"; g <
                        d; ++g) {
                        l = a[g];
                        var m = a[g + 1];
                        l === m ? ++k : k ? (f += w("th", "highcharts-table-topheading", 'scope="col" colspan="' + (k + 1) + '"', l), k = 0) : (l === b[g] ? c.exporting.useRowspanHeaders ? (m = 2, delete b[g]) : (m = 1, b[g] = "") : m = 1, f += w("th", "highcharts-table-topheading", 'scope="col"' + (1 < m ? ' valign="top" rowspan="' + m + '"' : ""), l))
                    }
                    f += "</tr>"
                }
                if (b) {
                    f += "<tr>";
                    g = 0;
                    for (d = b.length; g < d; ++g) "undefined" !== typeof b[g] && (f += w("th", null, 'scope="col"', b[g]));
                    f += "</tr>"
                }
                return f + "</thead>"
            }(k, m, Math.max(f, m.length));
            b += "<tbody>";
            a.forEach(function(a) {
                b +=
                    "<tr>";
                for (var c = 0; c < f; c++) b += w(c ? "td" : "th", null, c ? "" : 'scope="row"', a[c]);
                b += "</tr>"
            });
            b += "</tbody></table>";
            a = {
                html: b
            };
            z(this, "afterGetTable", a);
            return a.html
        };
        b.Chart.prototype.downloadCSV = function() {
            var a = this.getCSV(!0);
            f(c(a, "text/csv") || "data:text/csv,\ufeff" + encodeURIComponent(a), this.getFilename() + ".csv")
        };
        b.Chart.prototype.downloadXLS = function() {
            var a = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head>\x3c!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>Ark1</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--\x3e<style>td{border:none;font-family: Calibri, sans-serif;} .number{mso-number-format:"0.00";} .text{ mso-number-format:"@";}</style><meta name=ProgId content=Excel.Sheet><meta charset=UTF-8></head><body>' +
                this.getTable(!0) + "</body></html>";
            f(c(a, "application/vnd.ms-excel") || "data:application/vnd.ms-excel;base64," + d.btoa(unescape(encodeURIComponent(a))), this.getFilename() + ".xls")
        };
        b.Chart.prototype.viewData = function() {
            this.dataTableDiv || (this.dataTableDiv = A.createElement("div"), this.dataTableDiv.className = "highcharts-data-table", this.renderTo.parentNode.insertBefore(this.dataTableDiv, this.renderTo.nextSibling));
            this.dataTableDiv.innerHTML = this.getTable();
            z(this, "afterViewData", this.dataTableDiv)
        };
        if (a =
            b.getOptions().exporting) F(a.menuItemDefinitions, {
            downloadCSV: {
                textKey: "downloadCSV",
                onclick: function() {
                    this.downloadCSV()
                }
            },
            downloadXLS: {
                textKey: "downloadXLS",
                onclick: function() {
                    this.downloadXLS()
                }
            },
            viewData: {
                textKey: "viewData",
                onclick: function() {
                    this.viewData()
                }
            }
        }), a.buttons && a.buttons.contextButton.menuItems.push("separator", "downloadCSV", "downloadXLS", "viewData");
        e.map && (e.map.prototype.exportKey = "name");
        e.mapbubble && (e.mapbubble.prototype.exportKey = "name");
        e.treemap && (e.treemap.prototype.exportKey =
            "name")
    });
    k(c, "masters/modules/export-data.src.js", [], function() {})
});
//# sourceMappingURL=export-data.js.map