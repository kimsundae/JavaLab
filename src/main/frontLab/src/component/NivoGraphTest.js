import { ResponsiveLine } from '@nivo/line'


export default function NivoGraphTest(){
    let data = [

        {
            "id": "germany",
            "color": "hsl(24, 70%, 50%)",
            "data": [
                {
                    "x": "plane",
                    "y": 28
                },
                {
                    "x": "테스트1",
                    "y": 100
                },
                {
                    "x": "테스트2",
                    "y": 100
                },
                {
                    "x": "테스트3",
                    "y": 200
                },
                {
                    "x": "테스트4",
                    "y": 200
                },
                {
                    "x": "테스트5",
                    "y": 200
                },
                {
                    "x": "테스트6",
                    "y": 200
                },
                {
                    "x": "테스트7",
                    "y": 200
                },
                {
                    "x": "테스트8",
                    "y": 200
                },{
                    "x": "테스트9",
                    "y": 200
                },{
                    "x": "테스트10",
                    "y": 200
                },
                {
                    "x": "테스트11",
                    "y": 200
                },
                {
                    "x": "테스트12",
                    "y": 200
                },
                {
                    "x": "테스트13",
                    "y": 200
                },{
                    "x": "테스트14",
                    "y": 200
                },
                {
                    "x": "테스트15",
                    "y": 200
                },
                {
                    "x": "테스트16",
                    "y": 500
                },
                {
                    "x": "helicopter",
                    "y": 1
                },
                {
                    "x": "boat",
                    "y": 56
                },
                {
                    "x": "train",
                    "y": 170
                },
                {
                    "x": "subway",
                    "y": 53
                },
                {
                    "x": "bus",
                    "y": 219
                },
                {
                    "x": "car",
                    "y": 197
                },
                {
                    "x": "moto",
                    "y": 277
                },
                {
                    "x": "bicycle",
                    "y": 25
                },
                {
                    "x": "horse",
                    "y": 198
                },
                {
                    "x": "skateboard",
                    "y": 131
                },
                {
                    "x": "others",
                    "y": 23
                }
            ]
        },
        {
            "id": "norway",
            "color": "hsl(123, 70%, 50%)",
            "data": [
                {
                    "x": "plane",
                    "y": 275
                },
                {
                    "x": "helicopter",
                    "y": 1
                },
                {
                    "x": "boat",
                    "y": 193
                },
                {
                    "x": "train",
                    "y": 204
                },
                {
                    "x": "subway",
                    "y": 271
                },
                {
                    "x": "bus",
                    "y": 67
                },
                {
                    "x": "car",
                    "y": 145
                },
                {
                    "x": "moto",
                    "y": 154
                },
                {
                    "x": "bicycle",
                    "y": 30
                },
                {
                    "x": "horse",
                    "y": 191
                },
                {
                    "x": "skateboard",
                    "y": 39
                },
                {
                    "x": "others",
                    "y": 14
                }
            ]
        }
    ]
    // install (please try to align the version of installed @nivo packages)
// yarn add @nivo/line

// make sure parent container have a defined height when using
// responsive component, otherwise height will be 0 and
// no chart will be rendered.
// website examples showcase many properties,
// you'll often use just a few of them.
    const MyResponsiveLine = (data) => (
        <ResponsiveLine
            data={data}
            margin={{ top: 150, right: 200, bottom: 50, left: 60 }}
            xScale={{ type: 'point' }}
            yScale={{
                type: 'linear',
                min: 'auto',
                max: 'auto',
                stacked: true,
                reverse: false
            }}
            yFormat=" >-.2f"
            axisTop={null}
            axisRight={null}
            axisBottom={{
                tickSize: 5,
                tickPadding: 5,
                tickRotation: 0,
                legend: '날짜',
                legendOffset: 36,
                legendPosition: 'middle'
            }}
            axisLeft={{
                tickSize: 5,
                tickPadding: 5,
                tickRotation: 0,
                legend: '매출',
                legendOffset: -40,
                legendPosition: 'middle'
            }}
            pointSize={10}
            pointColor={{ theme: 'background' }}
            pointBorderWidth={2}
            pointBorderColor={{ from: 'serieColor' }}
            pointLabelYOffset={-12}
            useMesh={true}
            legends={[
                {
                    anchor: 'bottom-right',
                    direction: 'column',
                    justify: false,
                    translateX: 100,
                    translateY: 0,
                    itemsSpacing: 0,
                    itemDirection: 'left-to-right',
                    itemWidth: 80,
                    itemHeight: 20,
                    itemOpacity: 0.75,
                    symbolSize: 12,
                    symbolShape: 'circle',
                    symbolBorderColor: 'rgba(0, 0, 0, .5)',
                    effects: [
                        {
                            on: 'hover',
                            style: {
                                itemBackground: 'rgba(0, 0, 0, .03)',
                                itemOpacity: 1
                            }
                        }
                    ]
                }
            ]}
        />
    )
    return(<>
        <div style={{width:"1200px",height:"500px"}}>
            {MyResponsiveLine(data)}
        </div>
    </>)
}