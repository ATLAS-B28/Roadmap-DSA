import asyncio


async def fetch_data_sim():
    await asyncio.sleep(3)
    return "Data Fetched Successfully"

async def main():
    print("Start")
    result = await fetch_data_sim()
    print(result)
    print("End")

asyncio.run(main())