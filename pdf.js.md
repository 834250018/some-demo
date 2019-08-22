相关：https://www.jianshu.com/p/2fd2dda76360

# 已封装好的组件：PDF.vue
此组件返回数据为五个，

1.签署页码

2.签署X轴位置 3.签署Y轴位置（xy轴坐标原点为pdf当前页的左下角）

4.印章图片宽度

5.印章图片高度

使用pdf.js传入base64图片用于渲染pdf

盖章操作实际为对印模的定位，把位置数据传入后端保存，骑缝章仅记录y坐标

演示:后台-》模板管理-》B2B模板-》新建

# pdf.js主要使用代码
```
// 引入
import PDFJS from 'pdfjs-dist'
// 依赖
PDFJS.GlobalWorkerOptions.workerSrc =  "https://cdn.gzsdkj.top/pdf.worker.js";
PDFJS.getDocument({
                data: baseData, // 图片
                cMapUrl: 'https://cdn.jsdelivr.net/npm/pdfjs-dist@2.0.943/cmaps/',
                cMapPacked: true
            }).then(pdf=> {// pdf proxy对象
                _this.renderPageAsync(pdf, numPages, start)
            }).catch(function (error) {//加上catch 
            });

        renderPageAsync: async function (pdf, numPages, current) {
            var _this =this
            for (let i = 1; i <= numPages; i++) {
                // 当前页数据
                let page = await pdf.getPage(i)
                // 获取当前页视图（样式、大小）
                var viewport = page.getViewport(_this.zoom * _this.CSS_UNITS)
                var div = document.createElement('div')
                var pdfView = document.getElementById("pdfView")
                pdfView.appendChild(div)
    			// canvas标签承载pdf渲染
                let canvas = document.createElement("canvas")
                let context = canvas.getContext('2d')
                div.appendChild(canvas)
                // 文本渲染路径指向context，视图渲染指向viewport
                let renderContext = {
                    canvasContext: context,
                    viewport: viewport
                };
                // 渲染当前页pdf
                var renderTask = page.render(renderContext);
    
                 renderTask.then(()=> {
                        var  Progress =100/numPages*i;
                        if(Progress>=100){
                            
                        }
                        return page.getTextContent()
                    }).then((textContent)=>{
                        // 创建文本图层div
                        const textLayerDiv = document.createElement('div')
                        textLayerDiv.setAttribute('class', 'textLayer')
                        textLayerDiv.style.width = Math.floor(viewport.width)  +"px"
                        textLayerDiv.style.height = Math.floor(viewport.height) + "px"
                        // 将文本图层div添加至每页pdf的div中
                        
                        let pageDiv = document.getElementById(`box${i}`)
                        pageDiv.appendChild(textLayerDiv)
                        // 创建新的TextLayerBuilder实例
                        let textLayer = new TextLayerBuilder({
                        textLayerDiv: textLayerDiv,
                        pageIndex: page.pageIndex,
                        viewport: viewport
                        })
                        textLayer.setTextContent(textContent)
                        textLayer.render()
                    }).catch(function(error) {
                        //加上catch
                        if(_this.loading)
                        console.log(error);
                    });
            }
        }
```

## 拖拽

* 主要是鼠标左键事件,鼠标移动事件,鼠标松开事件
* 鼠标左键事件:启用鼠标移动事件,计算鼠标距离整个pdf左下角的左边距跟下边距,还有鼠标距离图片左下角的左边距跟下边距,来控制图片移动的界限
* 鼠标移动事件:根据鼠标位置对图片位置进行调整,超出界限不再移动
* 鼠标松开事件:禁用鼠标移动事件